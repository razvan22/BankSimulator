package com.company.account;

import com.company.client.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import static com.company.BankSimulatorUtilities.currentDateAsString;

public class Account implements Serializable {
    private Random random = new Random();
    private AccountType type;
    private String clearingNumber = "8403-8";
    private String accountNumber = accountNumberGenerator();
    private double balance = 0.0;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(AccountType type) {
        this.type = type;
    }

    private String accountNumberGenerator() {
        int nr = random.nextInt(9);
        String accountNr = "";

        for (int i = 0; i < 9; i++) {
            nr = random.nextInt(9);
            if ((i % 3) == 0) {
                accountNr += " ";
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void showBalance() {
        System.out.printf("Your current balance is : %s kr %n", getBalance());
    }

    private void displayTransaction(Transaction transaction) {
        System.out.printf("\n  %s  %s  %s kr %s", transaction.getReceiver(), transaction.getDate(), transaction.getAmount(), transaction.getAction().getAction());
    }

    public void displayTransactions() {
        transactions.stream()
                .forEach(this::displayTransaction);
        System.out.println("\n");
    }

    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void registerTransaction(String senderName, Client receiver, Double amount) {
        Transaction senderTransaction = new Transaction(amount, currentDateAsString(), receiver.getName(), TransactionAction.SENT);
        saveTransaction(senderTransaction);
        Transaction receiverTransaction = new Transaction(amount, currentDateAsString(), senderName, TransactionAction.RECEIVED);
        receiver.getAccount().saveTransaction(receiverTransaction);
    }

    public void withdrawalAmount(Double amount) {
        if ((getBalance() - amount) < 0.0) {
            System.out.printf("Insufficient funds , your current balance is %s", getBalance());
        } else {
            setBalance(getBalance() - amount);
        }
    }

    public void depositAmount(Double amount) {
        setBalance(getBalance() + amount);
    }
}

