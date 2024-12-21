package CodeSoftTasks;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the account balance
    public double getBalance() {
        return balance;
    }
}

class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Display ATM options
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Handle user input for transactions
    public void handleTransaction() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;

                case 2: // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;

                case 3: // Check balance
                    System.out.println("Current Balance: $" + bankAccount.getBalance());
                    break;

                case 4: // Exit the ATM
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4); // Repeat until exit
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set an initial balance for the user's bank account
        System.out.print("Enter initial balance for your account: $");
        double initialBalance = scanner.nextDouble();

        // Create a bank account with the initial balance
        BankAccount account = new BankAccount(initialBalance);

        // Create an ATM object with the user's bank account
        ATM atm = new ATM(account);

        // Start handling ATM transactions
        atm.handleTransaction();
    }
}
