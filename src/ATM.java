import java.util.Scanner;

public class ATM {
    
    private User currentUser;
    private Scanner scanner;

    // Constructor
    public ATM(User currentUser) {
        this.currentUser = currentUser;
        this.scanner = new Scanner(System.in);
    }
    public void run(){
        authenticateUser();
        int choice;

    }
    private void authenticateUser() {
        System.out.print("Enter user ID: ");
        String enteredUserId = scanner.next();
        System.out.print("Enter user PIN: ");
        String enteredPIN = scanner.next();

        if (currentUser.getUserId().equals(enteredUserId) && currentUser.getUserPIN().equals(enteredPIN)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed. Exiting...");
            System.exit(0);
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= currentUser.getAccountBalance()) {
            double newBalance = currentUser.getAccountBalance() - amount;
            currentUser.setAccountBalance(newBalance);
            System.out.println("Withdrawal successful. Remaining balance: " + newBalance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }


    private void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            double newBalance = currentUser.getAccountBalance() + amount;
            currentUser.setAccountBalance(newBalance);
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Invalid amount.");
        }
    }
}
}
