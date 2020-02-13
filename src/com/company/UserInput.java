package com.company;

import java.util.Scanner;

public class UserInput {
static Scanner input = new Scanner(System.in);

    public static String writeString(String messageForUser){
        System.out.printf("%s ", messageForUser);
        return input.nextLine();
    }

    public static int writeInt(String messageForUser){
        System.out.printf("%s ",messageForUser);
        return input.nextInt();
    }
}
