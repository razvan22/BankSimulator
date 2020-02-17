package com.company;

import com.company.account.Account;
import com.company.databaseManager.DatabaseManager;
import com.company.users.Admin;
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
                 newClient();
                break;
                case 2:
                    DatabaseManager.read("JavaDB/UsersData/Clients/Jon.dat");
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
                    DatabaseManager.users.get(userName).getType();

                }else {
                   System.out.println(ANSI_RED+"Not a valid user !!");
                }
        }
    }


    private void loginMenu(){
        System.out.printf("\n\n\t\t\t\t\t\t\tJava Bank Simulator\n\n"+
                "\t 1. Login\n\t 2.Read \n0. EXIT\n");
    }

    private void newClient() throws IOException {
       UserType clientType = UserType.CLIENT;
        Account account = new Account();
       Client client = new Client("Jon", "Asmn","VillandsVanga","678909-232",
               "jon@.com","09878767","userJon","pass",clientType,account);

       DatabaseManager.write("JavaDB/UsersData/Clients/"+client.getFirstName(),client);
//       DatabaseManager.write("JavaDB/UsersData/Clients/"+client.getFirstName()+"account",account);

    }

   private void newAdmin () throws IOException {
       Admin admin = new Admin("root","admin");

       DatabaseManager.write("JavaDB/UsersData/Clients/"+admin.getUserName(),admin);
   }


   private void showUsers(){

       for (String key : DatabaseManager.users.keySet()){
           System.out.printf("First name: %s\n", DatabaseManager.users.get(key).getFirstName());
       }
   }


}
