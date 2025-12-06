package main.java.DesignPatterns.StructuralPatterns.FacadePattern;

public class Main {

    public static void main(String[] args){
        APIGatewayFacade facade = new APIGatewayFacade();
        System.out.println(facade.initiatePayment("Dhruv","1234","2000rs"));
    }
}
