import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class CustomerList extends ArrayList<Customer> {
} // end CustomerList

public class Bank implements HasMenu {
    private Admin admin; // the single bank admin
    private CustomerList customers; // every customer in the bank
    private Scanner input = CheckingAccount.input; // same shared Scanner as the other menus

    public static void main(String[] args) {
        new Bank();
    } // end main

    public Bank() {
        admin = new Admin();
        customers = new CustomerList();
        // uncomment the next two lines to refresh data
        // loadSampleCustomers();
        // saveCustomers();
        loadCustomers();
        start();
        saveCustomers();
    } // end Bank

    public void loadSampleCustomers() {
        customers = new CustomerList();

        Customer alice = new Customer("Alice", "1111");
        alice.getChecking().setBalance(1000);
        alice.getSavings().setBalance(1000);
        alice.getSavings().setInterestRate(0.05);
        customers.add(alice);

        Customer bob = new Customer("Bob", "2222");
        bob.getSavings().setInterestRate(0.05);
        customers.add(bob);

        Customer cindy = new Customer("Cindy", "3333");
        cindy.getSavings().setInterestRate(0.05);
        customers.add(cindy);
    } // end loadSampleCustomers

    public String menu() {
        System.out.println("\nBank Menu");
        System.out.println("0) Exit system");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        System.out.print("Action (0-2): ");
        return input.nextLine();
    } // end menu

    public void start() {
        String choice = "";
        while (!choice.equals("0")) {
            choice = menu();
            if (choice.equals("1")) {
                System.out.println("Admin login");
                if (admin.login()) {
                    startAdmin();
                } // end if
            } else if (choice.equals("2")) {
                loginAsCustomer();
            } // end if
        } // end while
    } // end start

    public void startAdmin() {
        String choice = "";
        while (!choice.equals("0")) {
            choice = admin.menu();
            if (choice.equals("1")) {
                fullCustomerReport();
            } else if (choice.equals("2")) {
                addUser();
            } else if (choice.equals("3")) {
                applyInterest();
            } // end if
        } // end while
    } // end startAdmin

    public void loginAsCustomer() {
        System.out.println("Customer login");
        System.out.print("User name: ");
        String userName = input.nextLine();
        System.out.print("PIN: ");
        String pin = input.nextLine();

        Customer currentCustomer = null;
        for (Customer customer : customers) {
            if (customer.login(userName, pin)) {
                currentCustomer = customer;
            } // end if
        } // end for

        if (currentCustomer == null) {
            System.out.println("Customer not found");
        } else {
            currentCustomer.start();
        } // end if
    } // end loginAsCustomer

    public void fullCustomerReport() {
        System.out.println("Full customer report");
        for (Customer customer : customers) {
            System.out.println(customer.getReport());
        } // end for
    } // end fullCustomerReport

    public void addUser() {
        System.out.println("Add User");
        System.out.print("Name: ");
        String userName = input.nextLine();
        System.out.print("PIN: ");
        String pin = input.nextLine();
        Customer customer = new Customer(userName, pin);
        customer.getSavings().setInterestRate(0.05);
        customers.add(customer);
    } // end addUser

    public void applyInterest() {
        System.out.println("Apply interest");
        for (Customer customer : customers) {
            customer.getSavings().calcInterest();
            System.out.println("New balance: " + customer.getSavings().getBalanceString());
        } // end for
    } // end applyInterest

    public void saveCustomers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("customers.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(customers);
            objOut.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try
    } // end saveCustomers

    public void loadCustomers() {
        try {
            FileInputStream fileIn = new FileInputStream("customers.dat");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            customers = (CustomerList) objIn.readObject();
            objIn.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // end try
    } // end loadCustomers
} // end Bank
