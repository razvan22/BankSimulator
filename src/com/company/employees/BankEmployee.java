package com.company.employees;

import com.company.client.Client;
import com.company.users.User;
import com.company.users.UserType;

import java.util.ArrayList;

public class BankEmployee extends User {
    private long serialVersionUID = 1L;
    public String dateOfEmployment;
    private ArrayList<Client> clientsList = new ArrayList<>();

    public BankEmployee(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password, UserType userType, String dateOfEmployment) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.EMPLOYEE);
        this.dateOfEmployment = dateOfEmployment;
    }
    public void showAllClients(){
        for ( Client client: clientsList) {
            System.out.println(client.getName());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Show balance :");
        showName();

    }
    private void showName(){
        System.out.println(getName());
    }
}
