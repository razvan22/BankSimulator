package com.company.users;

public abstract class Person {
    private String firstName;
    private String lasName;
    private String address;
    private int socialSecurityNumber;
    private int emailAddress;
    private int phoneNumber;

    public Person(String firstName, String lasName, String address, int socialSecurityNumber, int emailAddress, int phoneNumber) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.address = address;
        this.socialSecurityNumber = socialSecurityNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public String getAddress() {
        return address;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getEmailAddress() {
        return emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
