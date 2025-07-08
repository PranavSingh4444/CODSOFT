import java.util.Scanner;

// Class to represent the bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Amount deposited: ₹" + amount);
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println(" Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(" Amount withdrawn: ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println(" Current Balance: ₹" + balance);
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM.");
                    break;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance
        BankAccount userAccount = new BankAccount(5000.0);  // Starting with ₹5000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
