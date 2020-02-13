package com.company.account;

import java.util.Random;

public class Account {
    private Random random = new Random();
    private AccountType accountType ;
    private String clearing = "8403-8";
    private String accountNr = accountNrGenerator();
    private double balance = 0.0;

    public Account(AccountType accountType) {
        this.accountType = accountType;
    }

    private String accountNrGenerator(){
      int nr = random.nextInt(9);
      String accountNr = "";

      for (int i = 0; i<9; i++){
          nr = random.nextInt(9);
          if ((i%3)== 0){
              accountNr+= " ";
          }
          accountNr += Integer.toString(nr);
      }
      return accountNr;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getClearing() {
        return clearing;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public double getBalance() {
        return balance;
    }
}

