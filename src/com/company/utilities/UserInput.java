package com.company.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
   static Scanner s = new Scanner(System.in);

    public static int getInt(){
        while (true){
            try {
                return s.nextInt();
            } catch ( InputMismatchException e){
                s.nextLine();
                System.out.print("Type only numbers between 0 and 9 : \n");
            }
        }
    }

    public static String getString(){
        while (true){
            try {
                return s.next();
            } catch ( InputMismatchException e){
                s.nextLine();
                System.out.print("Not valid input !!! \n");
            }
        }
    }

    public static double getDouble(){
        while (true){
            try{
                return s.nextDouble();
            } catch (InputMismatchException e){
                s.nextLine();
            }
        }
    }

}
