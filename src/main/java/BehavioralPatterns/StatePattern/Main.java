package main.java.BehavioralPatterns.StatePattern;

public class Main {

    public static void main(String[] args){
        TransportMode car = new Car();
        TransportMode bike = new Bike();
        TransportMode walk = new Walking();
        TransportMode cycle = new Cycling();

        DirectionService directionService = new DirectionService();
        directionService.setState(car);
        directionService.getETA();
        directionService.getDirections();

        directionService.setState(bike);
        directionService.getETA();
        directionService.getDirections();

        directionService.setState(walk);
        directionService.getETA();
        directionService.getDirections();

        directionService.setState(cycle);
        directionService.getETA();
        directionService.getDirections();

    }
}
