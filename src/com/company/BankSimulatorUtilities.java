package com.company;

import com.company.utilities.UserInput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankSimulatorUtilities {

    protected static void loginMenu() {
        System.out.printf("\n\nJava Bank Simulator\n\n" +
                "1. Login\n0. EXIT\n");
    }

    protected static String askForEmail(){
        System.out.printf("Login\nemail: ");
        return UserInput.getString();
    }

    protected static String askForPassword(){
        System.out.print("password: ");
        return UserInput.getString();
    }

    protected static String currentDateAsString(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm MM.dd.yyyy ");
        return dateFormat.format(date);
    }
}
