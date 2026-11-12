public class Main {
    public static void main(String[] args) {


        BankAccount b1=new BankAccount("10011","Abubekr",25);
        BankAccount b2=new BankAccount("10012","Nesredin",200);
        try {
            BankAccount b3=new BankAccount("10014","Abreham",20);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        try {
            BankAccount b4=new BankAccount("10013","",100);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        try {
            BankAccount b5=new BankAccount("10013","hassen",Double.NaN);
        }catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());

        }

        b1.deposit(75);
        b1.withdraw(35);
        System.out.println("Name: "+ b1.getAccountHolder() + " Balance: " + b1.getBalance());

        b2.deposit(100);
        b2.withdraw(150);
        System.out.println("Name: "+ b2.getAccountHolder() + " Balance: " + b2.getBalance());
        b2.withdraw(0);

        b2.deposit(Double.NaN);
        b2.deposit(Double.POSITIVE_INFINITY);
        b2.withdraw(Double.NaN);

        BankAccount overflowTest =
                new BankAccount("10015", "Test", Double.MAX_VALUE);

        boolean result = overflowTest.deposit(Double.MAX_VALUE);

        System.out.println("Deposit result: " + result);
        System.out.println("Balance: " + overflowTest.getBalance());
    }
}





