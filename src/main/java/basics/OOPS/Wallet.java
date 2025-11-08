package main.java.basics.OOPS;

public class Wallet implements PaymentMethod{

    private final String walletId;

    private final String customerName;

    public Wallet(String upiId, String customerName) {
        this.walletId = upiId;
        this.customerName = customerName;
    }

    public String getWalletId(){
        return walletId;
    }

    public String getCustomerName(){
        return customerName;
    }

    @Override
    public void pay() {
        System.out.println("Payment Done by Wallet ID "+ walletId);
    }
}
