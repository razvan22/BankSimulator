package com.company.users;

import com.company.account.Account;

import java.io.Serializable;

public class Client extends User implements Serializable {

    private Account account = new Account();

    public Client(String firstName, String lasName, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String userName, String password, UserType type, Account account) {
        super(firstName, lasName, address, socialSecurityNumber, emailAddress, phoneNumber, userName, password, type);
        this.account = account;
    }
}
