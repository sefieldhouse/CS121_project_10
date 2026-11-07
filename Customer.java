public class Customer extends User {
    private CheckingAccount checking; // customer's checking account
    private SavingsAccount savings; // customer's savings account

    public static void main(String[] args) {
        Customer customer = new Customer();
        if (customer.login()) {
            customer.start();
        } // end if
    } // end main

    public Customer() {
        setUserName("Alice");
        setPIN("0000");
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    } // end Customer

    public Customer(String userName, String PIN) {
        setUserName(userName);
        setPIN(PIN);
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    } // end Customer

    public String menu() {
        System.out.println("\nCustomer Menu");
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) change PIN");
        System.out.print("Action (0-3): ");
        return input.nextLine();
    } // end menu

    public void start() {
        String choice = "";
        while (!choice.equals("0")) {
            choice = menu();
            if (choice.equals("1")) {
                System.out.println("Checking Account");
                checking.start();
            } else if (choice.equals("2")) {
                System.out.println("Savings Account");
                savings.start();
            } else if (choice.equals("3")) {
                changePin();
            } // end if
        } // end while
    } // end start

    public void changePin() {
        System.out.print("Enter new PIN: ");
        String newPIN = input.nextLine();
        setPIN(newPIN);
        System.out.println("PIN changed.");
	// System.out.println("Current pin: " + getPIN()); // I addeed this to make sure the pin is actually changing correctly 
    } // end changePin

    public String getReport() {
        return "Customer: " + getUserName() + "\nChecking: "
            + checking.getBalanceString() + "\nSavings: " + savings.getBalanceString();
    } // end getReport
} // end Customer
