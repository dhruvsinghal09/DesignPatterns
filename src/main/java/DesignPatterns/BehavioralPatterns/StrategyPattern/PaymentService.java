package main.java.DesignPatterns.BehavioralPatterns.StrategyPattern;

public class PaymentService {

    PaymentStrategy strategy;

    PaymentService(PaymentStrategy ps){
        this.strategy=ps;
    }

    public void pay(int amount){
        strategy.makePayment(amount);
    }

}
