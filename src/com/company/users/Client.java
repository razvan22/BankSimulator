package com.company.users;

import com.company.account.Account;

import java.io.Serializable;

public class Client extends User implements Serializable {

    private Account account = new Account();

    public Client(String firstName, String lasName, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String userName, String password, UserType type) {
        super(firstName, lasName, address, socialSecurityNumber, emailAddress, phoneNumber, userName, password, type);

    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLasName() {
        return super.getLasName();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public String getSocialSecurityNumber() {
        return super.getSocialSecurityNumber();
    }

    @Override
    public String getEmailAddress() {
        return super.getEmailAddress();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public UserType getType() {
        return super.getType();
    }
}
