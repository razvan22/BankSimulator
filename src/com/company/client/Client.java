package com.company.client;

import com.company.account.Account;
import com.company.account.AccountType;
import com.company.users.User;
import com.company.users.UserType;

import java.io.Serializable;

import static com.company.databaseManager.DatabaseSimulator.isAccountNumberValid;
import static com.company.utilities.UserInput.*;

public class Client extends User implements Serializable {
    private long serialVersionUID = 1L;
    private Account account = new Account(AccountType.PRIVATE) ;

    public Client(){
        this("Razvan-Petru", "Villands Vanga", "8906155356","razviy69@mail.com", "8906155356", "secret");
    }

    public Client(String name, String address, String socialSecurityNumber, String emailAddress, String phoneNumber, String password) {
        super(name, address, socialSecurityNumber, emailAddress, phoneNumber, password, UserType.CLIENT);
    }

    public Account getAccount() {
        return account;
    }

    private void showOptions(){
        System.out.println("\n1. Show balance\n" +
                "2. Show transactions\n" +
                "3. Transfer\n" +
                "4. Edit your information\n" +
                "0. Logout");
    }


    private void showUserData(){
        System.out.printf("%n%s \t%s%s %n",getName(), account.getClearingNumber(), account.getAccountNumber());
    }

    @Override
    public void displayMenu() {
        showUserData();
        boolean run = true;
        while (run){
            showOptions();
            switch (getInt()){
                case 1:
                   account.showBalance();
                    break;
                case 2:
                    account.displayTransactions();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    editInfo();
                    break;
                case 0:
                    System.out.println("exiting...");
                    run = false;
                    break;
            }
        }

    }

    private void transfer(){
        System.out.println("Write receiver account number:");
        String receiverAccountNumber = getString();
        if (isAccountNumberValid(receiverAccountNumber)){
            System.out.println("Write amount :");
            double amount = getDouble();


        }else {
            System.out.printf("The account number %s is not a valid!",receiverAccountNumber);
        }
    }

    private void editInfo(){
        System.out.println("\n1. Change address\n" +
                "2. Change email\n" +
                "3. Change phone number\n" +
                "4. Change password\n" +
                "0. Back to menu \n");
        boolean run = true;
        while (run){
            switch (getInt()){
                case 1:
                    System.out.print("\nWrite your mew address:");
                    setAddress(getString());
                    break;
                case 2:
                    System.out.print("Write your new email address:");
                    setEmailAddress(getString());
                    break;
                case 3:
                    System.out.print("Write your new phone number: ");
                    setPhoneNumber(getString());
                    break;
                case 4:
                    System.out.println("Write your new password: ");
                    setPassword(getString());
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }

}
class Test {
    public static void main(String[] args) {
        Client client = new Client();
        client.displayMenu();

    }
}
