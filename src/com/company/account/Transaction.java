package com.company.account;

public class Transaction {
   private double amount;
   private String date;
   private String receiver;

    public Transaction(double amount, String date, String receiver) {
        this.amount = amount;
        this.date = date;
        this.receiver = receiver;
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
