package main.java.DesignPatterns.BehavioralPatterns.StrategyPattern;

public class Main {

    public static void main(String[] args){

        //Create Strategy1
        PaymentStrategy ps = new CreditCard("DhruvCC","Dhruv Singhal");

        //Create Strategy1
        PaymentStrategy ps2 = new DebitCard("DhruvDC","Dhruv Singhal");

        //Create Strategy1
        PaymentStrategy ps3 = new UPI("dhruv@okhdfcbank","Dhruv Singhal");

        PaymentService paymentService = new PaymentService(ps);
        paymentService.pay(1000);
        paymentService = new PaymentService(ps2);
        paymentService.pay(999);
        paymentService = new PaymentService(ps3);
        paymentService.pay(998);
    }
}
