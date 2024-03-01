class User {
    private String userId;
    private String userPIN;
    private double accountBalance;

    // Constructor
    public User(String userId, String userPIN, double accountBalance) {
        this.userId = userId;
        this.userPIN = userPIN;
        this.accountBalance = accountBalance;
    }

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public String getUserPIN() {
        return userPIN;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    // Setting the account balance with new Balance
    public void setAccountBalance(double newBalance) {
        this.accountBalance = newBalance;
    }

    // Display details
    public void displayDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("User PIN: " + userPIN);
        System.out.println("Account Balance: $" + accountBalance);
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance: " + accountBalance);
    }

}
