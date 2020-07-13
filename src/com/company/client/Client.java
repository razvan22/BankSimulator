package com.company.client;

import com.company.account.Account;
import com.company.account.AccountType;
import com.company.databaseManager.DatabaseSimulator;
import com.company.users.User;
import com.company.users.UserType;
import com.company.utilities.PathsUtilities;

import java.io.Serializable;
import java.util.Scanner;

import static com.company.databaseManager.DatabaseSimulator.*;
import static com.company.utilities.UserInput.*;

public class Client extends User implements Serializable {
    private long serialVersionUID = 1L;
    private Account account = new Account(AccountType.PRIVATE) ;

    public Client(){
        this("Razvan Petru", "Villands Vanga", "8906155356","razvan@.com", "0720431428", "password");
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

    private void showUserInformation(){
        System.out.printf("%n\t\tWelcome %s\tbalance: %s kr%n%n %s\t account nr: %s%s%n %s\t\t %s%n %s\t\t %s%n ",getName(),account.getBalance(),getName(),
                account.getClearingNumber(), account.getAccountNumber(),getSocialSecurityNumber(),getAddress(),getPhoneNumber(),getEmailAddress());
    }

    @Override
    public void displayMenu() {
        showUserInformation();
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
        boolean run = true;
        while (run) {
            System.out.print("0. Back to menu.\nWrite receiver account number:");
            Scanner scanner = new Scanner(System.in);
            String receiverAccountNumber = scanner.nextLine();
            switch (receiverAccountNumber){
                case "0":
                    run = false;
                    break;
                default:
                    if (isAccountNumberValid(receiverAccountNumber)){
                        Client receiver = getUserByAccountNumber(receiverAccountNumber);
                        System.out.printf("Receiver is : %s with account number %s \n",receiver.getName(),receiver.account.getAccountNumber());
                        System.out.print("Write amount: ");
                        double amount = getDouble();
                        System.out.printf("You will transfer %s kr to the account with number %s%n",amount,receiver.account.getAccountNumber());
                        if (confirm()){
                            account.withdrawalAmount(amount);
                            receiver.account.depositAmount(amount);
                            account.registerTransaction(getName(),receiver,amount);
                            writeObject(PathsUtilities.generatePath(receiver),receiver);
                            System.out.println("\nTransfer successful !!\n");
                            run = false;
                        }else run = false;
                    }else {
                        System.out.printf("\nThe account number %s is not valid!\n",receiverAccountNumber);
                    }

            }

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
                case 5:
                    account.depositAmount(500.0);
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
        DatabaseSimulator.writeObject(PathsUtilities.generatePath(client),client);
    }
}
