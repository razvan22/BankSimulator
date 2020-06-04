package com.company;

import com.company.account.Account;
import com.company.account.AccountType;
import com.company.client.Client;
import com.company.databaseManager.DatabaseManager;
import com.company.users.User;
import com.company.users.UserInput;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BankSimulator {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private final int LOGIN = 1;
    private final int READ = 2;

   public BankSimulator() throws IOException, InvocationTargetException, IllegalAccessException {

        int option = -1;
        loginMenu();
        option = UserInput.writeInt("\n:");
        while (option != 0){

            switch (option){
                case LOGIN:
                 newClient();
                break;
                case 2:
                    displayUser("");
                break;
                default:
                    System.out.println("Not a valid option");

            }
            loginMenu();
            option = UserInput.writeInt("\n:");
        }
    }


    private void login() throws IOException {
        DatabaseManager.readUsersFilePath();
        boolean login= true;

        while (login){
            String userName = UserInput.writeString(ANSI_WHITE +"\n0.EXIT\nUser: ");
                if (userName.equals("0")){
                    System.out.println(ANSI_GREEN+"Logging out ...");
                    break;
                }
                if (DatabaseManager.userNameList.containsKey(userName)){
                    DatabaseManager.users.get(userName).getUserType();
                }else {
                   System.out.println(ANSI_RED+"Not a valid user !!");
                }
        }
    }


    private void displayUser(String path) throws InvocationTargetException, IllegalAccessException {

       Object user = DatabaseManager.select("JavaDB/UsersData/Clients/Jon.dat");

        Class class0 = user.getClass();
                    Method[] methods = class0.getMethods();
                    for (Method method : methods){
                        if (method.getName().startsWith("get")){
                            switch (method.getName()){
                                case "getFirstName":
                                    System.out.println("First name: "+ method.invoke(user));
                                    break;
                                case "getLastName":
                                    System.out.println("Last name: "+ method.invoke(user));
                                    break;
                                case "getAddress":
                                    System.out.println("Address: "+ method.invoke(user));
                                    break;
                                case "getSocialSecurityNumber":
                                    System.out.println("Social security number: "+ method.invoke(user));
                                    break;
                                case "getEmailAddress":
                                    System.out.println("email: "+ method.invoke(user));
                                    break;
                                case "getPhoneNumber":
                                    System.out.println("Phone number: "+ method.invoke(user));
                                    break;
                                case "getUserName":
                                    System.out.println("User name: "+ method.invoke(user));
                                    break;
                                case "getPassword":
                                    System.out.println("Password: "+ method.invoke(user));
                                    break;
                                case "getType":
                                    System.out.println("User is a: "+ method.invoke(user));
                                    break;
                            }

                        }
                    }
    }
    private void newClient() throws IOException {
        Account account = new Account(AccountType.PRIVATE);
       Client client = new Client(account);
        System.out.printf("Client name "+ client.getName());
    }

    private String filesPath(User user) throws IOException {
        String fileName = user.getName()+user.getName();
        Path path = Paths.get("JavaDB/UsersData/Clients/"+fileName);
        Files.createDirectory(path);
        return path.toString()+"/"+fileName;
    }


   private void showUsers(){

       for (String key : DatabaseManager.users.keySet()){
           System.out.printf("First name: %s\n", DatabaseManager.users.get(key).getName());
       }
   }



    private void loginMenu(){
        System.out.printf("\n\n\t\t\t\t\t\t\tJava Bank Simulator\n\n"+
                "\t 1. Login\n\t 2.Read \n0. EXIT\n");
    }
}
