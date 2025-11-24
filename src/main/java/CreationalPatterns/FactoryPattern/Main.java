package main.java.CreationalPatterns.FactoryPattern;

public class Main {

    public static void main(String[] args){
        Transport transport = TransportFactory.getTransportFactory("bike");
        transport.deliver();
        transport = TransportFactory.getTransportFactory("car");
        transport.deliver();
    }
}
