package main.java.basics.OOPS;

public class UPI implements PaymentMethod{

    private final String upiId;

    private final String customerName;

    public UPI(String upiId, String customerName) {
        this.upiId = upiId;
        this.customerName = customerName;
    }

    public String getUpiId(){
        return upiId;
    }

    public String getCustomerName(){
        return customerName;
    }

    @Override
    public void pay() {
        System.out.println("Payment Done by UPI ID "+ upiId);
    }
}
