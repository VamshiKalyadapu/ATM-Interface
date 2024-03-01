import java.util.Scanner;

public class ATM {
    private User[] users;
    private User currentUser;
    private Scanner scanner;

    // Constructor
    public ATM() {
        this.scanner = new Scanner(System.in);
    }

    // Main method to run ATM operations
    public void run() {
        addAccounts();

        int choice;
        do {
            displayMenu();

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
                    switchAccount();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Switch Account");
        System.out.println("5. Exit");
    }

    // Accounts
    private void addAccounts() {
        System.out.println("Welcome to the ATM!");
        System.out.print("\nEnter how many accounts do you want to add: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        users = new User[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            addUserAccount(i);
        }

        // Check if more than one account is added before calling authenticateUser()
        if (count > 1) {
            authenticateUser();
        }
    }

    // adding user accounts
    private void addUserAccount(int index) {
        System.out.print("Enter user ID: ");
        String userId = scanner.next();
        System.out.print("Enter user PIN: ");
        String userPIN = scanner.next();
        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();

        // Consume the newline character
        scanner.nextLine();

        users[index] = new User(userId, userPIN, initialBalance);
        System.out.println("Account" + (index + 1) + " added successfully");

    }

    private void authenticateUser() {

        System.out.println("\nDo you want to stay in the current account(Yes/No)");
        String str = scanner.next();
        if (str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y")) {
            return;
        } else if (str.equalsIgnoreCase("no") || str.equalsIgnoreCase("n")) {
            switchAccount();
        } else {
            System.out.println("Invalid input...");
            authenticateUser(); // Prompt again if the input is invalid
            return;
        }

        // currentUser is not null before continuing
        if (currentUser == null) {
            System.out.println("Error: currentUser is null.");
            System.exit(1);
        }
    }

    // Withdraw money
    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");

        // Prompt users to withdraw amount
        double amount = scanner.nextDouble();

        // checking the entered balance is not more than the current balance
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

    // Depositing money
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

    // Switching between accounts
    private void switchAccount() {
        if (users.length == 1) {
            currentUser = users[0];
            System.out.println("\nYou have added only one account");
            users[0].displayDetails();
            System.out.println("Now you are in " + users[0].getUserId() + "'s Account");
            return;
        }

        System.out.print("Enter the user ID of the account you want to switch to: ");
        String searchUserId = scanner.next();
        System.out.print("Enter the PIN of the account: ");
        String searchUserPIN = scanner.next();

        boolean accountFound = false;
        for (User user : users) {
            // checking user details are correct or not
            if (user != null && user.getUserId().equals(searchUserId) && user.getUserPIN().equals(searchUserPIN)) {
                System.out.println("\nswitched user account details:");
                user.displayDetails();
                currentUser = user;
                System.out.println("Now you are in " + currentUser.getUserId() + "'s Account");
                accountFound = true;
                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account not found or invalid credentials.");
        }
    }

}
