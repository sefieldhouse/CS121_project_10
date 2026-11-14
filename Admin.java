public class Admin extends User {

    public Admin() {
        setUserName("admin");
        setPIN("0000");
    } // end Admin

    public String menu() {
        System.out.println("\nAdmin Menu");
        System.out.println("0) Exit this menu");
        System.out.println("1) Full customer report");
        System.out.println("2) Add user");
        System.out.println("3) Apply interest to savings accounts");
        System.out.print("Action (0-3): ");
        return input.nextLine();
    } // end menu

    public void start() {
    } // end start

    public String getReport() {
        return "Admin: " + getUserName() + ", PIN: " + getPIN();
    } // end getReport
} // end Admin
