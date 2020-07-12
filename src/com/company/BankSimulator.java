package com.company;


import com.company.client.Client;
import com.company.databaseManager.DatabaseSimulator;
import com.company.employees.Admin;
import com.company.employees.BankEmployee;
import com.company.users.User;
import com.company.utilities.PathsUtilities;
import com.company.utilities.UserInput;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

import static com.company.BankSimulatorUtilities.askForEmail;
import static com.company.databaseManager.DatabaseSimulator.*;


public class BankSimulator {

    private final int LOGIN = 1;

    Client currentLoggedClient;
    BankEmployee currentLoggedEmployee ;
    Admin currentLoggedAdmin ;


    public BankSimulator() {
        loadAllObjects(PathsUtilities.dbFilesPaths());

        int option = -1;
        BankSimulatorUtilities.loginMenu();
        option = UserInput.getInt();
        while (option != 0) {

            switch (option) {
                case LOGIN:
                    login();
                    break;
                default:
                    System.out.println("Not a valid option");
            }
           BankSimulatorUtilities.loginMenu();
            option = UserInput.getInt();
        }
    }

    private void login(){
        String email = askForEmail();
        if (isEmailValid(email)){
            Object currentUser = getUserByEmail(email);
            showUserMenu(currentUser);
            writeObject(PathsUtilities.generatePath((User) currentUser),currentUser);


//            getUserByEmail(email);
//            switch (loggedUserType){
//                case "CLIENT":
//                String password = askForPassword();
//                    while (password != "0"){
//                        if (validateCredentials(email, askForPassword())){
//                            System.out.println("\nWelcome "+currentLoggedClient.getName());
//                        }
//                    }
//                    break;
//                case "EMPLOYEE":
//                    if (validateCredentials(email, askForPassword())) {
//                        System.out.println("\nWelcome " + currentLoggedEmployee.getName());
//                    }
//                    break;
//                case "ADMIN":
//
//                    break;
//            }

        } else {
            System.out.println("No user with " + email +" was found !!");
        }
    }





    private boolean validateCredentials(String email, String password){
        switch (email){
            case "CLIENT":
                if (currentLoggedClient.getEmailAddress().equals(email) && currentLoggedClient.getPassword().equals(password)){
                    return true;
                }
                break;
            case "EMPLOYEE":
                if (currentLoggedEmployee.getEmailAddress().equals(email) && currentLoggedEmployee.getPassword().equals(password)){
                    return true;
                }
                break;
            case "ADMIN":
                if (currentLoggedAdmin.getEmailAddress().equals(email) && currentLoggedAdmin.getPassword().equals(password)){
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean isEmailValid(String email){
        Predicate<User> isValidEmail = u -> u.getEmailAddress().equals(email);
        boolean match = false;
        if (!match){
         match = usersList.stream()
                 .map(u -> (User) u)
                 .anyMatch(isValidEmail);
        }
        return match;
    }

    private void loadAllObjects(File @NotNull [] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                loadAllObjects(file.listFiles());
            } else {
                usersList.add( DatabaseSimulator.readObjectFromFile(file.getPath()));

            }
        }
    }
//    private void getUserByEmail(String email){
//        if (DatabaseSimulator.getEmployeeByEmail(email) != null){
//            currentLoggedEmployee = DatabaseSimulator.getEmployeeByEmail(email);
//            loggedUserType = currentLoggedEmployee.getUserType().toString();
//        }
//    }
    private void showUserMenu(Object currentUser){
        try {
            Method[] methods = currentUser.getClass().getMethods();
            Method method = currentUser.getClass().getMethod("displayMenu",null);
            Object object = method.invoke(currentUser);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
