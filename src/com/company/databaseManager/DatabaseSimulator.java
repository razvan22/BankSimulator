package com.company.databaseManager;

import com.company.BankSimulator;
import com.company.client.Client;
import com.company.users.User;
import com.company.utilities.PathsUtilities;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.company.databaseManager.DatabaseSimulator.usersList;

public class DatabaseSimulator {
    public static List<Object> usersList = new ArrayList<>();

    public static void writeObject(String path, Object object) {
        try (ObjectOutputStream objectWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            objectWriter.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile(String path) {
        Object currentObject = null;
        try (ObjectInputStream read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    currentObject = read.readObject();
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException io) {
            System.out.println("IO Exception" + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
        return currentObject;
    }

    public static User getUserByEmail(String email) {
        Predicate<User> getUserWithEmail = u -> u.getEmailAddress().equals(email);
        Optional<User> matchingEmployee = null;
        try {
            matchingEmployee = usersList.stream()
                    .map(u -> (User) u)
                    .filter(getUserWithEmail)
                    .findFirst();
        } catch (NullPointerException e) {

        }
        if (matchingEmployee.isPresent()) {
            return matchingEmployee.get();
        } else {
            return null;
        }
    }

    public static Client getUserByAccountNumber(String accountNumber) {
        Predicate<Client> hasAccountNumber = client -> client.getAccount().getAccountNumber().replaceAll(" ", "").equals(accountNumber.replaceAll(" ", ""));
        Optional<Client> matchingClient = null;
        try {
            matchingClient = Optional.of(usersList.stream()
                    .map(u -> (Client) u)
                    .filter(hasAccountNumber)
                    .findFirst()
                    .get());
        } catch (NullPointerException e) {

        }
        if (matchingClient.isPresent()) {
            return matchingClient.get();
        } else return null;
    }

    public static boolean isAccountNumberValid(String accountNumber) {
        Predicate<Client> isValidEmail = u -> u.getAccount().getAccountNumber().replaceAll(" ", "").equals(accountNumber.replaceAll(" ", ""));
        boolean match = false;
        if (!match) {
            match = usersList.stream()
                    .map(c -> (Client) c)
                    .anyMatch(isValidEmail);
        }
        return match;
    }

    public static void loadAllObjects(File @NotNull [] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                loadAllObjects(file.listFiles());
            } else {
                usersList.add( DatabaseSimulator.readObjectFromFile(file.getPath()));

            }
        }
    }

    public static boolean isEmailValid(String email){
        Predicate<User> isValidEmail = u -> u.getEmailAddress().equals(email);
        boolean match = false;
        if (!match){
            match = usersList.stream()
                    .map(u -> (User) u)
                    .anyMatch(isValidEmail);
        }
        return match;
    }
}

class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        loadAllObjects(PathsUtilities.dbFilesPaths());
//        System.out.println(DatabaseSimulator.isAccountNumberValid("1375831688"));
        usersList.stream()
                .map(user -> (Client) user)
                .map(client -> client.getAccount().getAccountNumber().replaceAll(" ", ""))
                .forEach(System.out::println);
//        Client client = new Client();
//        Method[] clientMethods = client.getClass().getMethods();
//        Stream.of(clientMethods)
//                .map(m -> m.getName())
//                .forEach(System.out::println);
//        Stream.of(clientMethods)
//                .map(m -> m.getParameterTypes().toString())
//                .forEach(System.out::println);
//        Method method = client.getClass().getMethod("displayMenu",null);
//        Object object = method.invoke(client);
    }

    private static void loadAllObjects(File @NotNull [] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                loadAllObjects(file.listFiles());
            } else {
                usersList.add(DatabaseSimulator.readObjectFromFile(file.getPath()));

            }
        }
    }
}

