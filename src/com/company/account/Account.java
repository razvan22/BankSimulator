package com.company.account;

import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable {
    private Random random = new Random();
    private AccountType type;
    private String clearingNumber = "8403-8";
    private String accountNumber = accountNumberGenerator();
    private double balance = 0.0;

    public Account(AccountType type) {
        this.type = type;
    }

    private String accountNumberGenerator(){
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
        return type;
    }

    public String getClearingNumber() {
        return clearingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

