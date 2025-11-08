package main.java.BehavioralPatterns.StrategyPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentService {

    PaymentStrategy strategy;

    PaymentService(PaymentStrategy ps){
        this.strategy=ps;
    }

    public void pay(int amount){
        strategy.makePayment(amount);
    }

}
