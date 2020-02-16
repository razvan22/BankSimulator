package com.company;

import com.company.fileManager.FileManager;
import com.company.users.Client;
import com.company.users.UserType;

import java.io.IOException;

import java.util.*;

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

   public BankSimulator() throws IOException {

        int option = -1;
        loginMenu();
        option = UserInput.writeInt("\n:");
        while (option != 0){

            switch (option){
                case LOGIN:
                   login();
                break;
                default:
                    System.out.println("Not a valid option");

            }
            loginMenu();
            option = UserInput.writeInt("\n:");
        }
    }

    private void login() throws IOException {
        FileManager.readUsersFilePath();
        boolean login= true;

        while (login){
            String userName = UserInput.writeString(ANSI_WHITE +"\n0.EXIT\nUser: ");
                if (userName.equals("0")){
                    System.out.println(ANSI_GREEN+"Logging out ...");
                    break;
                }
                if (FileManager.usersFilesPath.containsKey(userName)){
                    System.out.println("This is a valid user name ");
                }else {
                   System.out.println(ANSI_RED+"Not a valid user !!");
                }



        }
    }
    private void loginMenu(){
        System.out.printf("\n\n\t\t\t\t\t\t\tJava Bank Simulator\n\n"+
                "\t 1. Login\n\t 0. EXIT\n");
    }

   private void newClient(){
       Map<String,String> client = new HashMap<String,String>();
     UserType clientType = UserType.CLIENT;
     Client newClient =  new Client(UserInput.writeString("First name :"),
                UserInput.writeString("Last name: "),
                UserInput.writeString("Address: "),
                UserInput.writeString("Social security number: "),
                UserInput.writeString("@mail: "),
                UserInput.writeString("Phone number: "),
                UserInput.writeString("User name: "),
                UserInput.writeString("Password: "),
                clientType);
        client.put("First name: ",newClient.getFirstName());
        client.put("Last name: ",newClient.getLasName());
   }

   private void clientTest() throws IOException {
       UserType clientType = UserType.CLIENT;
       Client client = new Client("Jon","Mahon","Kristianstad","73094",
               "jon@gmail.com","898989891","jon","jonbBon",clientType);
       FileManager.usersList.put("Jon",client);
       FileManager.writeUsersData("JavaDB/UsersData/Clients/"+client.getUserName());
   }

   private void showUsers(){
       for (String key : FileManager.usersList.keySet()){
           System.out.printf("First name: %s\n", FileManager.usersList.get(key).getFirstName());
       }
   }


}
