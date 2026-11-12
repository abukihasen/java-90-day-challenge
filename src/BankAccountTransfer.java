public class  BankAccountTransfer{

    public static boolean transfer(
            BankAccount src,
            BankAccount dest,
            double amount
    ) {

        // Guard 1: Validate accounts
        if (src == null || dest == null) {
            return false;
        }

        // Guard 2: Prevent transferring to the same account
        if (src == dest) {
            return false;
        }

        // Guard 3: Validate amount
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        // Guard 4: Prevent destination balance overflow
        double newDestinationBalance = dest.getBalance() + amount;
        if (!Double.isFinite(newDestinationBalance)
                || newDestinationBalance <= dest.getBalance()) {
            return false;
        }

        // Guard 5: Withdraw from source
        if (!src.withdraw(amount)) {
            return false;
        }

        // Guard 6: Deposit into destination
        if (dest.deposit(amount)) {
            return true;
        }

        // Rollback: Restore the source balance
        boolean restored = src.deposit(amount);

        if (restored) {
            System.out.println("Transfer rolled back successfully.");
        } else {
            System.out.println("CRITICAL: Rollback failed!");
        }

        return false;
    }




    public static void main(String[] args) {

        BankAccount acc1 =
                new BankAccount("ACC-101", "Abebe", 500.0);

        BankAccount acc2 =
                new BankAccount("ACC-102", "Kebede", 200.0);

        BankAccount acc3 =
                new BankAccount("ACC-103", "Jemal", 100.0);

        BankAccount acc4 =
                new BankAccount("ACC-104", "Ebisa", 200.0);


        // TEST 1: Successful Transfer
        System.out.println("\n=== TEST 1: Successful Transfer ===");
        boolean success = transfer(acc1, acc2, 150.0);
        System.out.println("Result: " + success);


        // TEST 2: Transfer to Same Account
        System.out.println("\n=== TEST 2: Transfer to Same Account ===");
        boolean failure1 = transfer(acc3, acc3, 150.0);
        System.out.println("Result: " + failure1);


        // TEST 3: Insufficient Balance
        System.out.println("\n=== TEST 3: Insufficient Balance ===");
        boolean failure2 = transfer(acc3, acc2, 150.0);
        System.out.println("Result: " + failure2);


        // TEST 4: Negative Amount
        System.out.println("\n=== TEST 4: Negative Transfer Amount ===");
        boolean failure3 = transfer(acc4, acc2, -150.0);
        System.out.println("Result: " + failure3);


        // TEST 5: NaN Amount
        System.out.println("\n=== TEST 5: NaN Transfer Amount ===");
        boolean failure4 = transfer(acc4, acc2, Double.NaN);
        System.out.println("Result: " + failure4);


        // TEST 6: Positive Infinity
        System.out.println("\n=== TEST 6: Positive Infinity ===");
        boolean failure5 = transfer(acc4, acc2, Double.POSITIVE_INFINITY);
        System.out.println("Result: " + failure5);

        System.out.println("\n=== TEST 7: Null Source Account ===");

        boolean test7 = transfer(null,acc2,50);
        System.out.println("Expected output : false");
        System.out.println("Result: "+test7);

        System.out.println("\n=== TEST 8: Null Destination  Account ===");
        boolean test8 = transfer(acc1,null,50);
        System.out.println("Expected output : false");
        System.out.println("Result: "+test8);

        BankAccount source =
                new BankAccount("ACC-105", "Source", Double.MAX_VALUE);

        BankAccount destination =
                new BankAccount("ACC-106", "Destination", Double.MAX_VALUE);

        double amount = Double.MAX_VALUE / 2;
        boolean result = transfer(source, destination, amount);
        System.out.println("\n=== TEST 9: Destination Overflow ===");

        System.out.println("Result: " + result);
        System.out.println("Source balance: " + source.getBalance());
        System.out.println("Destination balance: " + destination.getBalance());

        boolean result2= transfer(source,destination,50);
        System.out.println("\n=== TEST 10: Transfer Overflow ===");

        System.out.println("Result of MAX-value plus 50: " + result2);
        System.out.println("Source balance: " + source.getBalance());
        System.out.println("Destination balance: " + destination.getBalance());


        // FINAL ACCOUNT BALANCES
        System.out.println("\n========== FINAL ACCOUNT BALANCES ==========");

        System.out.println("ACC-101 (Abebe): $" + acc1.getBalance());
        System.out.println("ACC-102 (Kebede): $" + acc2.getBalance());
        System.out.println("ACC-103 (Jemal): $" + acc3.getBalance());
        System.out.println("ACC-104 (Ebisa): $" + acc4.getBalance());


    }

}



