
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Module2KevinLeonor - A simple GUI Bank Balance Application
 * CSC372 - Module 2: Critical Thinking Assignment
 * 
 * This application allows users to:
 * - Enter an initial bank account balance
 * - Deposit funds into the account
 * - Withdraw funds from the account
 * - Display the current balance within a JPanel
 */
public class Module2KevinLeonor extends JFrame implements ActionListener {

    // GUI Components
    private JPanel displayPanel;
    private JLabel balanceLabel;
    private JLabel statusLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton displayButton;
    private JButton exitButton;

    // Bank Account Variable
    private double balance;

    /**
     * Constructor - Sets up the GUI components and layout
     */
    public Module2KevinLeonor() {
        // Initialize balance
        balance = 0.0;

        // Set up the JFrame
        setTitle("Bank Balance Application");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- Top Panel: Initial Balance Input ---
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Amount"));
        JLabel amountLabel = new JLabel("Amount ($): ");
        amountField = new JTextField(15);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        // --- Center Panel: Display Balance (JPanel requirement) ---
        displayPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        displayPanel.setBorder(BorderFactory.createTitledBorder("Account Information"));
        balanceLabel = new JLabel("Current Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel = new JLabel("Welcome! Please enter your initial balance.", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        displayPanel.add(balanceLabel);
        displayPanel.add(statusLabel);

        // --- Bottom Panel: Buttons (JButton requirement) ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        displayButton = new JButton("Display Balance");
        exitButton = new JButton("Exit");

        // Add ActionListeners to buttons (ActionListener requirement)
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        displayButton.addActionListener(this);
        exitButton.addActionListener(this);

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(exitButton);

        // Add panels to the JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Prompt user for initial balance
        getInitialBalance();

        // Make the frame visible
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Prompts the user to enter an initial bank account balance
     */
    private void getInitialBalance() {
        String input = JOptionPane.showInputDialog(this,
                "Enter your initial bank account balance:",
                "Initial Balance",
                JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.isEmpty()) {
            try {
                balance = Double.parseDouble(input);
                if (balance < 0) {
                    balance = 0;
                    statusLabel.setText("Invalid amount. Balance set to $0.00.");
                } else {
                    statusLabel.setText("Initial balance set successfully.");
                }
                updateBalanceDisplay();
            } catch (NumberFormatException e) {
                balance = 0;
                statusLabel.setText("Invalid input. Balance set to $0.00.");
                updateBalanceDisplay();
            }
        }
    }

    /**
     * Handles all button click events
     * Implements ActionListener interface
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            performDeposit();
        } else if (e.getSource() == withdrawButton) {
            performWithdrawal();
        } else if (e.getSource() == displayButton) {
            displayBalance();
        } else if (e.getSource() == exitButton) {
            exitApplication();
        }
    }

    /**
     * Performs a deposit operation
     */
    private void performDeposit() {
        String input = amountField.getText().trim();
        if (input.isEmpty()) {
            statusLabel.setText("Error: Please enter an amount to deposit.");
            return;
        }

        try {
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                statusLabel.setText("Error: Deposit amount must be positive.");
            } else {
                balance += amount;
                statusLabel.setText(String.format("Deposited: $%.2f successfully.", amount));
                updateBalanceDisplay();
                amountField.setText("");
            }
        } catch (NumberFormatException ex) {
            statusLabel.setText("Error: Please enter a valid numeric amount.");
        }
    }

    /**
     * Performs a withdrawal operation
     */
    private void performWithdrawal() {
        String input = amountField.getText().trim();
        if (input.isEmpty()) {
            statusLabel.setText("Error: Please enter an amount to withdraw.");
            return;
        }

        try {
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                statusLabel.setText("Error: Withdrawal amount must be positive.");
            } else if (amount > balance) {
                statusLabel.setText("Error: Insufficient funds for this withdrawal.");
            } else {
                balance -= amount;
                statusLabel.setText(String.format("Withdrew: $%.2f successfully.", amount));
                updateBalanceDisplay();
                amountField.setText("");
            }
        } catch (NumberFormatException ex) {
            statusLabel.setText("Error: Please enter a valid numeric amount.");
        }
    }

    /**
     * Displays the current balance in the JPanel
     */
    private void displayBalance() {
        updateBalanceDisplay();
        statusLabel.setText("Balance displayed successfully.");
    }

    /**
     * Updates the balance label in the display panel
     */
    private void updateBalanceDisplay() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
    }

    /**
     * Displays final balance and exits the application
     */
    private void exitApplication() {
        JOptionPane.showMessageDialog(this,
                String.format("Final Remaining Balance: $%.2f\n\nThank you for using Bank Balance App!",
                        balance),
                "Goodbye",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Module2KevinLeonor());
    }
}

