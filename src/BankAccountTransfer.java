public class  BankAccountTransfer {

    public static boolean transfer(
            BankAccount src,
            BankAccount dest,
            double amount
    ) {
        if (src == null || dest == null) {
            return false;
        } else if (src == dest) {
            return false;
        } else if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        } else if (!Double.isFinite(dest.getBalance() + amount)) {
            return false;
        } else {

            if (src.withdraw(amount)) {
                if (dest.deposit(amount)) {
                    return true;
                } else {
                    boolean restored = src.deposit(amount);
                    if (restored) {
                        System.out.println("Transfer rolled back successfully");
                    } else {
                        System.out.println("CRITICAL: Rollback failed!");
                    }
                    return false;
                }

            }
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


        // FINAL ACCOUNT BALANCES
        System.out.println("\n========== FINAL ACCOUNT BALANCES ==========");

        System.out.println("ACC-101 (Abebe): $" + acc1.getBalance());
        System.out.println("ACC-102 (Kebede): $" + acc2.getBalance());
        System.out.println("ACC-103 (Jemal): $" + acc3.getBalance());
        System.out.println("ACC-104 (Ebisa): $" + acc4.getBalance());
    }
}