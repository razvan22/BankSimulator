package com.company.account;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Account {
    private Random random = new Random();
    private String clearing = "8403-8";
    private String accountNr = accountNrGenerator();
    private double balance = 0.0;


    public String accountNrGenerator(){
      int nr = random.nextInt(9);
      String accountNr = "";

      for (int i = 0; i<9; i++){
          nr = random.nextInt(9);
          if ((i%3)== 0){
              accountNr+= " ";
          }
          accountNr += Integer.toString(nr);
          System.out.println(accountNr);
      }
      return accountNr;
    }


}
class Test{
    public static void main(String[] args) {
        Account account = new Account();
       account.accountNrGenerator();
    }
}
