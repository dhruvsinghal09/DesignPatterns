package main.java.BehavioralPatterns.StatePattern;

public class Cycling implements TransportMode {
    @Override
    public void getETA() {
        System.out.println("The ETA via Cycle is 20 minutes");
    }

    @Override
    public void getDirections() {
        System.out.println("Take the next right and follow the lane for 5 KM.");
    }
}
