package BANK;
/*Creating the child class of BankAccount class named SavingsAccount which inherits its
parent's classes variables. This class has its own variable too.*/

public class SavingsAccount extends BankAccount {

    //Static variable that is constant in all the methods and Main class
    private static final double minBalance = 0;

    //Parameterized constructor of the class
    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    //Method overriding from the abstract class. It increases the balance by calculation
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    //Method overriding from the abstract class. It decreases the balance by calculation
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
        } else {
            System.out.println("\nInsufficient balance !");
        }
    }
}