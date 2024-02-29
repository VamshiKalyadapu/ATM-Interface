import java.util.Scanner;

public class ATM {

    private User currentUser;
    private Scanner scanner;

    // Constructor
    public ATM(User currentUser) {
        this.currentUser = currentUser;
        this.scanner = new Scanner(System.in);
    }

    // Main method to run ATM operations
    public void run() {
        authenticateUser();

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentUser.checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        } while (choice != 4);
    }

    private void authenticateUser() {
        System.out.println("Welcome to the ATM!");

        // Prompt users to enter user ID and PIN
        System.out.print("Enter user ID: ");
        String enteredUserId = scanner.next();
        System.out.print("Enter user PIN: ");
        String enteredPIN = scanner.next();

        // Validate entered credentials against stored user data
        if (currentUser.getUserId().equals(enteredUserId) && currentUser.getUserPIN().equals(enteredPIN)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Entered invalid userID or userPIN. Exiting...");
            System.exit(0);
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");

        // Prompt users to withdraw amount
        double amount = scanner.nextDouble();

        //checking the entered balance is not more than the current balance
        if (amount > 0 && amount <= currentUser.getAccountBalance()) {
            double newBalance = currentUser.getAccountBalance() - amount;
            currentUser.setAccountBalance(newBalance);
            System.out.println("\nWithdrawal successful. Remaining balance: " + newBalance);
        } else {
            System.out.println("\nYour account balance is : " + currentUser.getAccountBalance());
            System.out.println("Invalid amount or insufficient funds.");
            System.out.println("Enter the valid amount to withdraw...\n");
        }
    }

    private void depositMoney() {
        System.out.print("Enter the amount to deposit: ");

        // Prompt users to deposit amount
        double amount = scanner.nextDouble();

        if (amount > 0) {
            double newBalance = currentUser.getAccountBalance() + amount;
            currentUser.setAccountBalance(newBalance);
            System.out.println("\nDeposit successful. New balance: " + newBalance);
        } else {
            System.out.println("\nInvalid amount.");
            System.out.println("Enter the valid amount to deposit...\n");
        }
    }

}
