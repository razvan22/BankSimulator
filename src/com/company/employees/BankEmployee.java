package com.company.employees;

import com.company.users.User;
import com.company.users.UserType;

public class BankEmployee extends User {
    public String dateOfEmployment;
    private int numberOfClients;

    public BankEmployee(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password, UserType userType, String dateOfEmployment) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.BANK_EMPLOYEE);
        this.dateOfEmployment = dateOfEmployment;
    }
}
