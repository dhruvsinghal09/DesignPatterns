package main.java.DesignPatterns.StructuralPatterns.FacadePattern;

public class OrderService {

    public String getOrders(String orderId){
        return "Orders for orderId: ".concat(orderId);
    }
}
