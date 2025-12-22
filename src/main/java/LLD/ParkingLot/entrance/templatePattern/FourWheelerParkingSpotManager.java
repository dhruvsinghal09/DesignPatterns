package main.java.LLD.ParkingLot.entrance.templatePattern;

import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.StrategyPattern.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    public FourWheelerParkingSpotManager(ParkingStrategy parkingStrategy, List<ParkingSpot> spots) {
        super(parkingStrategy, spots);
    }
}
