package main.java.DesignPatterns.CreationalPatterns.FactoryPattern;

import java.util.Locale;

public class TransportFactory {

    public static Transport getTransportFactory(String type){
        switch (type.toLowerCase(Locale.ROOT)){
            case "bike":
                return new Bike();
            case "car":
                return new Car();
            case "bus":
                return new Car();
            default:
                throw new IllegalArgumentException("type not supported for transport");
        }
    }
}
