public class SavingsAccount extends CheckingAccount {
    private double interestRate; // interest rate for the savings account

    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();
        account.start();
    } // end main

    public void calcInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    } // end calcInterest

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    } // end setInterestRate

    public double getInterestRate() {
        return interestRate;
    } // end getInterestRate
} // end SavingsAccount
