package main.java.BehavioralPatterns.StrategyPattern;

public class UPI implements PaymentStrategy{

    private String upiId;

    private String customerName;

    public UPI(String upiId,String customerName){
        this.upiId=upiId;
        this.customerName=customerName;
    }
    @Override
    public void makePayment(int amount) {
        System.out.println("The payment completed via UPI for "+customerName + " of amount " + amount + " for upiId "+upiId);
    }
}
