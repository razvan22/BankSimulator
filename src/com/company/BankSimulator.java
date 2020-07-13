package com.company;

import com.company.client.Client;
import com.company.users.User;
import com.company.utilities.PathsUtilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.company.BankSimulatorUtilities.*;
import static com.company.databaseManager.DatabaseSimulator.*;
import static com.company.utilities.UserInput.getInt;


public class BankSimulator {
    private final int LOGIN = 1;

    public BankSimulator() {
        loadAllObjects(PathsUtilities.dbFilesPaths());
        usersList.stream()
                .map(user -> (Client) user)
                .map(client -> client.getAccount().getAccountNumber())
                .forEach(System.out::println);

        int option = -1;
        loginMenu();
        option = getInt();
        while (option != 0) {
            switch (option) {
                case LOGIN:
                    login();
                    break;
                default:
                    System.out.println("Not a valid option");
            }
           loginMenu();
            option = getInt();
        }
    }

    private void login(){
        String email = askForEmail();
        String userPassword = askForPassword();
        if (isEmailValid(email)){
            Object currentUser = getUserByEmail(email);
            if (!userPassword.equals(getUserPassword(currentUser))){
                System.out.println("Wrong email or password!!");
            }
            if (userPassword.equals(getUserPassword(currentUser))){
                showUserMenu(currentUser);
                writeObject(PathsUtilities.generatePath((User) currentUser),currentUser);
            }
        } else {
            System.out.println("Wrong email or password!!");
        }
    }

    private void showUserMenu(Object currentUser){
        try {
            Method[] methods = currentUser.getClass().getMethods();
            Method method = currentUser.getClass().getMethod("displayMenu",null);
            Object object = method.invoke(currentUser);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    private String getUserPassword(Object currentUser){
        try {
            Method[] methods = currentUser.getClass().getMethods();
            Method method = currentUser.getClass().getMethod("getPassword", null);
            Object object = method.invoke(currentUser);
            return object.toString();

        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
