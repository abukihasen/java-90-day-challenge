

public class BankAccount {
    private final String accountNumber;
    private final String accountHolder;

    private double balance;
    private static final double MINIMUM_BALANCE =25.00;

    public BankAccount(String accountNumber,
                       String accountHolder,
                       double initialBalance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number cannot be null or empty");
        }

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException(
                    "Account name cannot be null or empty");
        }

        if (!Double.isFinite(initialBalance)
                || initialBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException(
                    "Initial balance must be finite and at least 25 birr");
        }

        this.accountNumber = accountNumber.trim();
        this.accountHolder = accountHolder.trim();
        this.balance = initialBalance;
    }


    public boolean deposit(double amount) {

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;
        }

        double newBalance = balance + amount;

        // Prevent overflow
        if (!Double.isFinite(newBalance)) {
            System.out.println("Deposit would cause balance overflow.");
            return false;
        }
        if (newBalance <= balance) {
            System.out.println("Deposit amount is too small to change the balance.");
            return false;
        }


        balance = newBalance;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount must be finite and greater than zero");
            return false;
        }

        if (balance - amount < MINIMUM_BALANCE) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        return true;
    }

    public double getBalance(){
        return balance;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public String getAccountNumber() {
        return accountNumber;
    }


}


