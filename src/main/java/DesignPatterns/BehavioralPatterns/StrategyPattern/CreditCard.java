package main.java.DesignPatterns.BehavioralPatterns.StrategyPattern;

public class CreditCard implements PaymentStrategy{

    private String cardNo;

    private String customerName;

    public CreditCard(String cardNo,String customerName){
        this.cardNo=cardNo;
        this.customerName=customerName;
    }
    @Override
    public void makePayment(int amount) {
        System.out.println("The payment completed via Credit Card for "+customerName + " of amount " + amount + " for cardNo. "+cardNo);
    }
}
