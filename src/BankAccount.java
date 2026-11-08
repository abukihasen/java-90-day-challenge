

public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount( String accountHolder, double initialBalance ){
        this.accountHolder=accountHolder;
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }else {
            balance=initialBalance;
        }

    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount cannot be zero or negative");
        } else {
            balance += amount;
        }
    }
    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Amount cannot be zero or negative");
        }else if (balance<amount){
            System.out.println("insufficient balance to withdraw "+ amount);
        }else {
            balance-=amount;
        }
    }

    public double getBalance(){
        return balance;
    }
    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {

        BankAccount b1=new BankAccount("Abubekr",75);
        BankAccount b2=new BankAccount("Nesredin",25);
        try {
            BankAccount b3=new BankAccount("Nesredin",-25);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }



        b1.deposit(75);
        b1.withdraw(35);
        System.out.println("Name: "+ b1.accountHolder + " Balance: " + b1.getBalance());

        b2.deposit(100);
        b2.withdraw(150);
        System.out.println("Name: "+ b2.accountHolder + " Balance: " + b2.getBalance());
    }
}



