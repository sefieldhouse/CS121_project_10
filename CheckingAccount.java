import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance; // amount of money in the account
    public static Scanner input = new Scanner(System.in); // shared input for the menus

    public CheckingAccount() {
        balance = 0;
    } // end CheckingAccount

    public CheckingAccount(double balance) {
        this.balance = balance;
    } // end CheckingAccount dbl

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount();
        account.start();
    } // end main string

    public String menu() {
        System.out.println("\nAccount menu");
        System.out.println("0) quit");
        System.out.println("1) check balance");
        System.out.println("2) make a deposit");
        System.out.println("3) make a withdrawal");
        System.out.print("Please enter 0-3: ");
        return input.nextLine();
    } // end menu

    public void start() {
        String choice = "";
        while (!choice.equals("0")) {
            choice = menu();
            if (choice.equals("1")) {
                checkBalance();
            } else if (choice.equals("2")) {
                makeDeposit();
            } else if (choice.equals("3")) {
                makeWithdrawal();
            }
        }
    } // end start

    public double getBalance() {
        return balance;
    } // emd getBalance

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    } // end getBalanceString

    public void setBalance(double balance) {
        this.balance = balance;
    } // end setBalance

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    } // end checkBalance

    private double getDouble() {
        System.out.print("Enter amount: ");
        return Double.parseDouble(input.nextLine());
    } // end getDouble

    public void makeDeposit() {
        System.out.println("Making a deposit...");
        System.out.println("How much to deposit?");
        double amount = getDouble();
        balance = balance + amount;
        System.out.println("New balance: " + getBalanceString());
    } // end makeDeposit

    public void makeWithdrawal() {
        System.out.println("Making a withdrawal...");
        System.out.println("How much to withdraw?");
        double amount = getDouble();
        balance = balance - amount;
        System.out.println("New balance: " + getBalanceString());
    } // end makeWithdrawal
} // end class def
