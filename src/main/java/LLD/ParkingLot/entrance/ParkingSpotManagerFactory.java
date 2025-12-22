package main.java.LLD.ParkingLot.entrance;

import main.java.LLD.ParkingLot.entrance.StrategyPattern.NearestToElevatorStrategy;
import main.java.LLD.ParkingLot.entrance.StrategyPattern.NearestToEntranceStrategy;
import main.java.LLD.ParkingLot.entrance.templatePattern.FourWheelerParkingSpotManager;
import main.java.LLD.ParkingLot.entrance.templatePattern.ParkingSpotManager;
import main.java.LLD.ParkingLot.entrance.templatePattern.TwoWheelerParkingSpotManager;
import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;

import java.util.List;

public class ParkingSpotManagerFactory {

    public static ParkingSpotManager getParkingSpotManager(Vehicle vehicle, List<ParkingSpot> spots){
        return switch (vehicle.getVehicleType()){
            case TWO_WHEELER -> new TwoWheelerParkingSpotManager(new NearestToElevatorStrategy(),spots);
            case FOUR_WHEELER -> new FourWheelerParkingSpotManager(new NearestToEntranceStrategy(),spots);
        };
    }
}
