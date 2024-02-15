import java.util.Scanner;

class BankAccount {
    private double savingsBalance;
    private double checkingBalance;

    // Constructor to initialize account balances
    public BankAccount(double savingsBalance, double checkingBalance) {
        this.savingsBalance = savingsBalance;
        this.checkingBalance = checkingBalance;
    }

    // Method overloading for deposit
    public void deposit(double amount) {
        deposit(amount, "savings");
    }

    public void deposit(double amount, String accountType) {
        if (accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
            System.out.println("Deposit of $" + amount + " into savings account successful.");
        } else if (accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
            System.out.println("Deposit of $" + amount + " into checking account successful.");
        } else {
            System.out.println("Invalid account type.");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Savings Account Balance: $" + savingsBalance);
        System.out.println("Checking Account Balance: $" + checkingBalance);
    }

    // Withdraw money
    public void withdraw(double amount, String accountType) {
        if (accountType.equalsIgnoreCase("savings")) {
            if (amount <= savingsBalance) {
                savingsBalance -= amount;
                System.out.println("Withdrawal of $" + amount + " from savings account successful.");
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        } else if (accountType.equalsIgnoreCase("checking")) {
            if (amount <= checkingBalance) {
                checkingBalance -= amount;
                System.out.println("Withdrawal of $" + amount + " from checking account successful.");
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else {
            System.out.println("Invalid account type.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank Account Management System!");

        // Ask user to create an account and deposit initial balance
        System.out.print("Enter initial balance for savings account: $");
        double initialSavingsBalance = scanner.nextDouble();
        System.out.print("Enter initial balance for checking account: $");
        double initialCheckingBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialSavingsBalance, initialCheckingBalance);

        // Menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit money");
            System.out.println("2. Display balance");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    System.out.print("Enter account type (savings/checking): ");
                    String accountType = scanner.next();
                    account.deposit(depositAmount, accountType);
                    break;
                case 2:
                    account.displayBalance();
                    break;
                    case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    System.out.print("Enter account type (savings/checking): ");
                    accountType = scanner.next();
                    account.withdraw(withdrawalAmount, accountType);
                    // Display balance after withdrawal
                    System.out.println("Updated Account Balance:");
                    account.displayBalance();
                    break;
                
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Bank Account Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }

        scanner.close();
    }
}
