package com.company.users;

public class Teller extends User {
    public String dateOfEmployment;
    private int numberOfClients;


    public Teller(String firstName, String lasName, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String userName, String password, UserType type, String dateOfEmployment, int numberOfClients) {
        super(firstName, lasName, address, socialSecurityNumber, emailAddress, phoneNumber, userName, password, type);
        this.dateOfEmployment = dateOfEmployment;
        this.numberOfClients = numberOfClients;
    }
}
