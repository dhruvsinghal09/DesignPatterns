package main.java.basics.OOPS;

public class DebitCard extends Card{
    DebitCard(String cardNo, String customerName) {
        super(cardNo, customerName);
    }

    @Override
    public void pay() {
        System.out.println("Payment Done by Debit Card "+ getCardNo());
    }
}
