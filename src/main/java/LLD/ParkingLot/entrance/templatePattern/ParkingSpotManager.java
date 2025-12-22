package main.java.LLD.ParkingLot.entrance.templatePattern;

import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.StrategyPattern.ParkingStrategy;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;

import java.util.List;

public abstract class ParkingSpotManager {

    private ParkingStrategy parkingStrategy;
    private List<ParkingSpot> spots;

    public ParkingSpotManager(ParkingStrategy parkingStrategy,List<ParkingSpot> spots){
        this.parkingStrategy=parkingStrategy;
        this.spots=spots;
    }


    public ParkingSpot assignSpot(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingStrategy.assignSpace(vehicle,spots);
        System.out.println("Parking Spot Assigned for " + vehicle.getVehicleNumber() + " is " + parkingSpot.getSpotId());
        parkingSpot.setAvailable(false);
        parkingSpot.setVehicle(vehicle);
        return parkingSpot;
    }
}
