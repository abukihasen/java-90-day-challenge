

public class BankAccount {
    private final String accountNumber;
    private final String accountHolder;

    private double balance;
    private static final double MINIMUM_BALANCE =25.00;

    public BankAccount( String accountNumber ,String accountHolder, double initialBalance ){


        if(accountNumber==null || accountNumber.isBlank()){
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }else{
            this.accountNumber=accountNumber.trim();
        }
        if(accountHolder==null || accountHolder.isBlank()){
            throw new IllegalArgumentException("Account name cannot be null or empty");
        }else{
            this.accountHolder=accountHolder.trim();
        }


        if (!Double.isFinite(initialBalance) || initialBalance < MINIMUM_BALANCE ) {
            throw new IllegalArgumentException(
                    "Initial balance must be finite and at least 25 birr"
            );
        }else {
            balance=initialBalance;
        }

    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount must be finite and greater than zero");            return false;
        } else {
            balance += amount;
            return true;

        }
    }
    public boolean withdraw(double amount){
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount must be finite and greater than zero");
            return false;
        }else if (balance-amount<MINIMUM_BALANCE ){
            System.out.println("insufficient balance to withdraw "+ amount + " or invalid amount");
            return false;
        }else {
            balance-=amount;
            return true;
        }
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
    }
}



