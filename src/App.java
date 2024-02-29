public class App {
    public static void main(String[] args) throws Exception {
        User user = new User("123456", "7890", 1000.0);
        ATM atm = new ATM(user);
        atm.run();
    }
}
