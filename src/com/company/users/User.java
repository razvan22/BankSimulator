package com.company.users;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String firstName;
    private String lasName;
    private String address;
    private String socialSecurityNumber;
    private String emailAddress;
    private String phoneNumber;
    private String userName;
    private String password;
    private UserType type;


    public User(String firstName, String lasName, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String userName, String password, UserType type) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.address = address;
        this.socialSecurityNumber = socialSecurityNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.type = type;
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

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }
}
