package main.java.basics.OOPS;

import java.util.HashMap;

public class PaymentService {

    HashMap<String,PaymentMethod> paymentMethodHashMap;

    public PaymentService(){
        paymentMethodHashMap = new HashMap<>();
    }

    public void addPaymentMethod(String name,PaymentMethod pm){
        paymentMethodHashMap.putIfAbsent(name,pm);
    }

    public void makePayment(String paymentMethod){
        PaymentMethod pm = paymentMethodHashMap.get(paymentMethod);
        pm.pay();
    }

    public void deletePaymentMethod(String paymentMethod){
        paymentMethodHashMap.remove(paymentMethod);
        System.out.println("Payment method deleted " + paymentMethod);
    }
}
