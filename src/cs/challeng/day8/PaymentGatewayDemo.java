package cs.challeng.day8;

public class PaymentGatewayDemo {


    public interface Payable{

        boolean processPayment(double amount);

        String getReceipt();

        default void logTrace(double amount){
            System.out.println("AUDIT  Processing payment: $"+amount);
        }
    }
    public static abstract class AbstractGateway implements Payable{
        private final String merchantId;

        public AbstractGateway(String merchantId){
            this.merchantId=merchantId;
        }
        public String getMerchantId(){
            return merchantId;
        }
        public abstract double calculateFee(double amount);
    }
    public static class CreditCardGateway extends AbstractGateway{
        private String receipt;

        public CreditCardGateway(String merchantId){
            super(merchantId);
        }
        @Override
        public double calculateFee(double amount){
            return (amount * 2.5) / 100;
        }
        @Override
        public boolean processPayment(double amount){
            if (!Double.isFinite(amount)||amount<=0){
                return false;
            }
            double fee=calculateFee(amount);
            double total=amount+fee;
            if (!Double.isFinite(total)||!Double.isFinite(fee)){
                return false;
            }

            logTrace(amount);

            receipt="merchantId: "+getMerchantId()+
                    " Amount: "+ amount+
                    " Fee: "+ fee +
                    " Total: " + total;
            return true;
        }
        @Override
        public String getReceipt(){
            return receipt;
        }
    }
    public static void main(String[] args) {
        System.out.println("Day 08 Interfaces & Abstract Classes Challenge");
    }

}
