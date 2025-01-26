package BANK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*Creating FileHandler class to do the file operations. It consists of 1 string variable and
4 methods*/

public class FileHandler {

    /*Declaring a string variable to store the file's name. "bank_accounts.txt" file
    has been used in this application to store the given data and perform write and read
    operations*/
    private static final String FILE_NAME = "bank_accounts.txt";

    /*This method writes in the file. Appends the information in the file one after another*/
    public static void saveAccount(BankAccount account) {

    /*Exception Handling is used in here to avoid the errors*/
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(account.getAccountDetails());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    /*This method reads from the file. Reads the information one after another from the file*/
    public static List<SavingsAccount> loadAccounts() {

        /*Using Array List to store the account details in the array*/
        List<SavingsAccount> accounts = new ArrayList<>();

        /* Exception Handling */
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            /*Declaring a string variable line*/
            String line;
            /*Using while loop to run the process*/
            while ((line = reader.readLine()) != null) {
                /*Splits the lines with ','*/
                String[] parts = line.split(", ");
                /*Splits the first index by ':' and then moves to the second index*/
                String accountNumber = parts[0].split(": ")[1];
                /*Splits the second index by ':' and gets the second part  */
                String accountHolderName = parts[1].split(": ")[1];
                /*Gets the third part and convert the text into double to calculation*/
                double balance = Double.parseDouble(parts[2].split(": ")[1]);
                /*Adds the data to the Array List*/
                accounts.add(new SavingsAccount(accountNumber, accountHolderName, balance));
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return accounts;
    }

    /*This method updates the account information in the file*/
    public static void updateAccounts(List<SavingsAccount> accounts) {

        /*Exception Handling*/
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (SavingsAccount account : accounts) {
                /*Rewrites the account informations in the file*/
                writer.write(account.getAccountDetails());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    /*This method displays all the account's information from the Array List */
    public static void displayAccounts() {

        List<SavingsAccount> accounts = loadAccounts();
        
        //Using For loop for displaying the accounts
        for (SavingsAccount account : accounts) {
            System.out.println(account.getAccountDetails());
        }
    }
}