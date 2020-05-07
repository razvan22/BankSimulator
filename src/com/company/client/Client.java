package com.company.client;

import com.company.account.Account;
import com.company.users.User;
import com.company.users.UserType;

import java.io.Serializable;

public class Client extends User implements Serializable {
    private Account account ;

    public Client(Account account){
        this("Razvan-Petru", "Villands Vanga", "8906155356","razviy69@mail.com", "8906155356", "secret",account);
    }

    public Client(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password, Account account) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.CLIENT);
        this.account = account;
    }
}
