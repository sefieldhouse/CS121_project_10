import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {
    private String userName; // name used to log in
    private String PIN; // PIN used to log in
    private static final long serialVersionUID = 1L;

    // Use the same Scanner as the account menus.
    protected java.util.Scanner input = CheckingAccount.input;

    public boolean login() {
        System.out.print("User name: ");
        String name = input.nextLine();
        System.out.print("PIN: ");
        String pin = input.nextLine();
        return login(name, pin);
    } // end login

    public boolean login(String userName, String PIN) {
        if (this.userName.equals(userName) && this.PIN.equals(PIN)) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        } // end if
    } // end login

    public void setUserName(String userName) {
        this.userName = userName;
    } // end setUserName

    public String getUserName() {
        return userName;
    } // end getUserName

    public void setPIN(String PIN) {
        this.PIN = PIN;
    } // end setPIN

    public String getPIN() {
        return PIN;
    } // end getPIN

    public abstract String getReport();
} // end User
