package BANK;

/*Creating an Abstract Class BankAccount consists of 3 variables,
1 parameterized constructor, 2 abstract methods and 1 return method*/

abstract class BankAccount {
    
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    //This constructor takes inputs and store them in the variables
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    //Abstract method for Deposit
    public abstract void deposit(double amount);
    //Abstract method for Withdraw
    public abstract void withdraw(double amount);

    //Return method which returns details of the accounts that have been created
    public String getAccountDetails() {
        return "Account Number: " + accountNumber + ", Name: " + accountHolderName + ", Balance: " + balance;
    }
}