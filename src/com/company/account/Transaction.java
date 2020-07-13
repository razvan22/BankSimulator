package com.company.account;

import java.io.Serializable;

public class Transaction implements Serializable {
   private double amount;
   private String date;
   private String receiver;
    private TransactionAction action;

    public Transaction(double amount, String date, String receiver, TransactionAction action) {
        this.amount = amount;
        this.date = date;
        this.receiver = receiver;
        this.action = action;
    }

    public TransactionAction getAction() {
        return action;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getReceiver() {
        return receiver;
    }
}
