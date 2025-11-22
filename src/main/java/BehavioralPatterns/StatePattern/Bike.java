package main.java.BehavioralPatterns.StatePattern;

public class Bike implements TransportMode {
    @Override
    public void getETA() {
        System.out.println("The ETA via Bike is 8 minutes");
    }

    @Override
    public void getDirections() {
        System.out.println("Take the next right and follow the lane for 5 KM.");
    }
}
