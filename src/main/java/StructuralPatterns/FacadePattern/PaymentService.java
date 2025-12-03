package main.java.StructuralPatterns.FacadePattern;

public class PaymentService {

    public String processPayment(String payment){
        return "Process Payment of: ".concat(payment);
    }
}
