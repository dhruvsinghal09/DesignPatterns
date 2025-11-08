package main.java.basics.OOPS;

public class CreditCard extends Card{
    CreditCard(String cardNo, String customerName) {
        super(cardNo, customerName);
    }

    @Override
    public void pay() {
        System.out.println("Payment Done by Credit Card "+ getCardNo());
    }
}
