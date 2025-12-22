package main.java.LLD.ParkingLot.entrance.models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSpot {

    private String spotId;
    private Vehicle vehicle;
    private int distanceToEntry;
    private int distanceToElevator;
    AtomicInteger entry = new AtomicInteger();
    AtomicInteger elevator = new AtomicInteger();
    private boolean isAvailable;
    private int cost;

    public ParkingSpot(int cost){
        this.cost=cost;
        this.spotId= UUID.randomUUID().toString();
        this.distanceToEntry=entry.getAndAdd(1);
        this.distanceToElevator=elevator.getAndAdd(1);
        this.isAvailable=true;
    }

    public String getSpotId(){
        return spotId;
    }

    public int getCost(){
        return cost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getDistanceToEntry() {
        return distanceToEntry;
    }

    public int getDistanceToElevator() {
        return distanceToElevator;
    }
}
