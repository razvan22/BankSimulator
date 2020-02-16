package com.company;

import java.util.Scanner;

public class UserInput {

    public static String writeString(String messageForUser){
    Scanner input = new Scanner(System.in);
        System.out.print( messageForUser);
        return input.nextLine();
    }
    public static String writeString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int writeInt(String messageForUser){
        Scanner input = new Scanner(System.in);
        System.out.printf("%s ",messageForUser);
        return input.nextInt();
    }
}
