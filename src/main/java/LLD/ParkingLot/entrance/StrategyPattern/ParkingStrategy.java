package main.java.LLD.ParkingLot.entrance.StrategyPattern;

import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    public ParkingSpot assignSpace(Vehicle vehicle, List<ParkingSpot> spots);
}
