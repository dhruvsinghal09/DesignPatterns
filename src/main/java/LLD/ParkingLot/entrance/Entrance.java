package main.java.LLD.ParkingLot.entrance;

import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;
import main.java.LLD.ParkingLot.entrance.templatePattern.ParkingSpotManager;

public class Entrance {

    private ParkingSpotManager parkingSpotManager;

    public Entrance(ParkingSpotManager parkingSpotManager){
        this.parkingSpotManager=parkingSpotManager;
    }

    public ParkingSpot assignSpace(Vehicle vehicle){
        return parkingSpotManager.assignSpot(vehicle);
    }
}
