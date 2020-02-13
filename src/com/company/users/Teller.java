package com.company.users;

public class Teller extends Person {
    public int dateOfEmployment;


    public Teller(String firstName, String lasName, String address, int socialSecurityNumber, String emailAddress, int phoneNumber) {
        super(firstName, lasName, address, socialSecurityNumber, emailAddress, phoneNumber);
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
    public String getEmailAddress() {
        return super.getEmailAddress();
    }

    @Override
    public int getPhoneNumber() {
        return super.getPhoneNumber();
    }
}
