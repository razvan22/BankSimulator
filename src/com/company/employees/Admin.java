package com.company.employees;

import com.company.users.User;
import com.company.users.UserType;

import java.io.*;

public class Admin extends User implements Serializable {
    private long serialVersionUID = 1L;
    public Admin(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password, UserType userType) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.ADMIN);
    }
    public void addBankEmployeeUse(){};
    public void deleteBankEmployeeUser(){};
    public void editBankEmployeeUserInformation(){};

    @Override
    public void displayMenu() {

    }
}

