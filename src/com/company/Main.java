package com.company;

import com.company.account.Account;
import com.company.account.AccountType;
import com.company.users.Client;
import com.company.users.UserType;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
//        AccountType privateAccount = AccountType.PRIVATE;
        Account account = new Account(AccountType.PRIVATE);
        Client client = new Client("Razvan","Nechifor","villands",
                8906155,"@gmail.com",3342,account, UserType.CLIENT);
        System.out.println(client.getAccount().getAccountType().getType());
    }
}
