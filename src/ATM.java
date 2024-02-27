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
    private void authenticateUser(){
        
    }
}
