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

    public void setAccountBalance(double newBalance) {
        this.accountBalance = newBalance;
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance: " + accountBalance);
    }


}
