public class TestBankAccount {
    public static void main(String[] args) {

        // ===== Test Case 1: BankAccount basic operations =====
        System.out.println("***** TEST CASE 1: BankAccount Basic Operations *****\n");

        BankAccount account1 = new BankAccount("John", "Smith", 1001);
        account1.deposit(500.00);
        System.out.println("After depositing $500.00:");
        account1.accountSummary();

        account1.withdrawal(200.00);
        System.out.println("\nAfter withdrawing $200.00:");
        account1.accountSummary();

        System.out.println("\nAttempting to withdraw $400.00 (more than balance):");
        account1.withdrawal(400.00);
        account1.accountSummary();

        // ===== Test Case 2: CheckingAccount with overdraft =====
        System.out.println("\n***** TEST CASE 2: CheckingAccount with Overdraft *****\n");

        CheckingAccount checking1 = new CheckingAccount("Jane", "Doe", 2001, 1.5);
        checking1.deposit(100.00);
        System.out.println("After depositing $100.00:");
        checking1.displayAccount();

        System.out.println("\nAttempting to withdraw $150.00 (overdraft):");
        checking1.withdrawal(150.00);
        checking1.displayAccount();

        // ===== Test Case 3: CheckingAccount normal withdrawal =====
        System.out.println("\n***** TEST CASE 3: CheckingAccount Normal Withdrawal *****\n");

        CheckingAccount checking2 = new CheckingAccount("Alice", "Johnson", 2002, 2.0);
        checking2.deposit(1000.00);
        System.out.println("After depositing $1000.00:");
        checking2.displayAccount();

        System.out.println("\nWithdrawing $250.00 (within balance):");
        checking2.withdrawal(250.00);
        checking2.displayAccount();

        // ===== Test Case 4: Using setters and getters =====
        System.out.println("\n***** TEST CASE 4: Setters and Getters *****\n");

        BankAccount account2 = new BankAccount("Bob", "Brown", 1002);
        account2.deposit(750.00);
        System.out.println("Original account:");
        account2.accountSummary();

        account2.setFirstName("Robert");
        account2.setLastName("Williams");
        account2.setAccountID(1003);
        System.out.println("\nAfter updating name and account ID:");
        account2.accountSummary();

        System.out.println("First Name: " + account2.getFirstName());
        System.out.println("Last Name: " + account2.getLastName());
        System.out.println("Account ID: " + account2.getAccountID());
        System.out.println("Balance: $" + account2.getBalance());
    }
}
