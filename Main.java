package BANK;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner to take user input
        Scanner scanner = new Scanner(System.in);
        //Creating an object for the Welcome class
        Welcome w = new Welcome();
        //It appears first in the output screen
        w.WelcomeMsg();

        /*Using while loop and allowing users to choose the given options
        consecutively until they choose Exit.*/
        while (true) {
            System.out.println("\n\nChoose One Of The Options : \n");
            System.out.println("1. Create A New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display All Accounts");
            System.out.println("5. Exit");
            System.out.print("\n\nEnter Your Choice :  ");

            int choice = scanner.nextInt();
            //For consuming the character 'Enter'
            scanner.nextLine();

            //Using switch case for functioning
            switch (choice) {
                case 1:
                    w.WelcomeMsg();
                    System.out.print("\nEnter account number : ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("\nEnter account holder name : ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("\nEnter current balance : ");
                    double balance = scanner.nextDouble();

                    /*Creating an object for SavingsAccount class*/
                    SavingsAccount account = new SavingsAccount(accountNumber, accountHolderName, balance);
                    /*Saving the account in the FileHandler class*/
                    FileHandler.saveAccount(account);
                    System.out.println("\nAccount created successfully !\n");
                    break;

                case 2:
                    w.WelcomeMsg();
                    System.out.print("\nEnter account number : ");
                    String accNum = scanner.nextLine();
                    System.out.print("\nEnter deposit amount : ");
                    double depositAmount = scanner.nextDouble();
                    /*Inserts the list of the accounts from the loadAccounts() method in the
                    accounts variable*/
                    List<SavingsAccount> accounts = FileHandler.loadAccounts();
                    //Initializing the boolean variable as false
                    boolean depositSuccess = false;
                    for (SavingsAccount acc : accounts) {
                        if (acc.accountNumber.equals(accNum)) {
                            acc.deposit(depositAmount);
                            depositSuccess = true;
                            break;
                        }
                    }
                    /*If the despositSuccess variable appears to be true the file gets updated*/
                    if (depositSuccess) {
                        FileHandler.updateAccounts(accounts);
                        System.out.println("\nDeposit successful ! Thank You !\n");
                    } else {
                        System.out.println("\nAccount doesn't exist.\n");
                    }
                    break;

                case 3:
                    w.WelcomeMsg();
                    System.out.print("\nEnter account number : ");
                    String accWithdraw = scanner.nextLine();
                    System.out.print("\nEnter withdrawal amount : ");
                    double withdrawAmount = scanner.nextDouble();
                    /*Inserts the list of the accounts from the loadAccounts() method in the
                    accounts variable*/
                    accounts = FileHandler.loadAccounts();
                    //Initializing the boolean variable as false
                    boolean withdrawSuccess = false;
                    for (SavingsAccount acc : accounts) {
                        if (acc.accountNumber.equals(accWithdraw)) {
                            acc.withdraw(withdrawAmount);
                            withdrawSuccess = true;
                            break;
                        }
                    }
                    /*If the despositSuccess variable appears to be true the file gets updated*/
                    if (withdrawSuccess) {
                        FileHandler.updateAccounts(accounts);
                        System.out.println("\nWithdrawal successful !");
                    } else {
                        System.out.println("\nInsufficient balance !");
                    }
                    break;

                case 4:
                    w.WelcomeMsg();
                    System.out.println("\nDisplaying All Accounts\n\n");
                    /*Displays the accounts from the Array List*/
                    FileHandler.displayAccounts();
                    break;

                case 5:
                    System.out.println("\nThank You. Application Closed !\n");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice ! Please try again !\n");
                    /*No 'break' is used here so that the while loop can run again and allow users
                    to choose again*/
            }
        }
    }
}
