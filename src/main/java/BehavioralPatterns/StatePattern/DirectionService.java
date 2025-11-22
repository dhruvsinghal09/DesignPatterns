package main.java.BehavioralPatterns.StatePattern;

public class DirectionService {

    private TransportMode transportMode;

    public DirectionService(){
    }

    public void setState(TransportMode transportMode){
        this.transportMode = transportMode;
    }

    public void getETA(){
        transportMode.getETA();
    }

    public void getDirections(){
        transportMode.getDirections();
    }
}
