package main.java.DesignPatterns.BehavioralPatterns.StrategyPattern;

public class DebitCard implements PaymentStrategy{
    private String cardNo;

    private String customerName;

    public DebitCard(String cardNo,String customerName){
        this.cardNo=cardNo;
        this.customerName=customerName;
    }

    @Override
    public void makePayment(int amount) {
        System.out.println("The payment completed via Debit Card for "+customerName + " of amount " + amount + " for cardNo. "+cardNo);
    }
}
