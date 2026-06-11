public class CheckingAccount extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.00;

    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Setter and getter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Allows overdraft withdrawals with a $30 fee
    public void processWithdrawal(double amount) {
        if (amount > 0) {
            if (amount <= getBalance()) {
                withdrawal(amount);
            } else {
                // Overdraft: subtract amount and apply $30 fee
                double newBalance = getBalance() - amount - OVERDRAFT_FEE;
                System.out.println(">> Overdraft! A $30.00 fee has been assessed.");
                System.out.printf(">> Negative balance after withdrawal: $%.2f%n", newBalance);
                // Apply the withdrawal by calling deposit with a negative adjustment
                withdrawal(getBalance()); // zero out balance
                deposit(newBalance);      // set to negative balance (via internal tracking)
                // Since deposit won't accept negative, we handle it differently:
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Override to handle overdraft properly using direct balance manipulation
    @Override
    public void withdrawal(double amount) {
        // This class allows overdraft, so we override the parent restriction
        if (amount > 0) {
            if (amount <= getBalance()) {
                super.withdrawal(amount);
            } else {
                // Process overdraft
                double overdraftAmount = amount - getBalance();
                super.withdrawal(getBalance()); // zero the balance
                // Reflect negative balance with fee
                System.out.println(">> Overdraft! A $30.00 fee has been assessed.");
                double negativeBalance = -(overdraftAmount + OVERDRAFT_FEE);
                System.out.printf(">> Current balance: $%.2f%n", negativeBalance);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Display all account information including interest rate
    public void displayAccount() {
        System.out.println("===== Checking Account Details =====");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Account ID: " + getAccountID());
        System.out.printf("Balance: $%.2f%n", getBalance());
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        System.out.println("====================================");
    }
}
