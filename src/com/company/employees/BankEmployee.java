package com.company.employees;

import com.company.client.Client;
import com.company.users.User;
import com.company.users.UserType;

import java.util.ArrayList;

public class BankEmployee extends User {
    public String dateOfEmployment;
    private ArrayList<Client> clientsList = new ArrayList<>();

    public BankEmployee(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password, UserType userType, String dateOfEmployment) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.BANK_EMPLOYEE);
        this.dateOfEmployment = dateOfEmployment;
    }
    public void showAllClients(){
        for ( Client client: clientsList) {
            System.out.println(client.getName());
        }
    }
}
