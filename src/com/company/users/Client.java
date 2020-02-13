package com.company.users;

import com.company.account.Account;

public class Client extends Person{

    private Account account;
    private UserType userType;

    public Client(String firstName, String lasName, String address, int socialSecurityNumber, int emailAddress, int phoneNumber, Account account, UserType userType) {
        super(firstName, lasName, address, socialSecurityNumber, emailAddress, phoneNumber);
        this.account = account;
        this.userType = userType;
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
    public int getSocialSecurityNumber() {
        return super.getSocialSecurityNumber();
    }

    @Override
    public int getEmailAddress() {
        return super.getEmailAddress();
    }

    @Override
    public int getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public Account getAccount() {
        return account;
    }

}
