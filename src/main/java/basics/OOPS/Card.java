package main.java.basics.OOPS;

abstract class Card implements PaymentMethod{

    private final String cardNo;

    private final String customerName;


    Card(String cardNo, String customerName) {
        this.cardNo = cardNo;
        this.customerName = customerName;
    }

    public String getCardNo(){
        return cardNo;
    }

    public String getCustomerName(){
        return customerName;
    }
}
