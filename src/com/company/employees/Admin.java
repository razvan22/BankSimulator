package com.company.employees;

import com.company.users.User;
import com.company.users.UserType;

import java.io.*;

public class Admin extends User implements Serializable {

    public Admin(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password, UserType userType) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.ADMIN);
    }
    public void addBankEmployeeUse(){};
    public void deleteBankEmployeeUser(){};
    public void editBankEmployeeUserInformation(){};

}

