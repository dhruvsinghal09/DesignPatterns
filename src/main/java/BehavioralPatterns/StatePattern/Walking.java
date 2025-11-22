package main.java.BehavioralPatterns.StatePattern;

public class Walking implements TransportMode {
    @Override
    public void getETA() {
        System.out.println("The ETA via Walking is 40 minutes");
    }

    @Override
    public void getDirections() {
        System.out.println("Take the next right and follow the lane for 5 KM.");
    }
}
