package main.java.LLD.ParkingLot.entrance.StrategyPattern;

import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;

import java.util.Comparator;
import java.util.List;

public class NearestToElevatorStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot assignSpace(Vehicle vehicle, List<ParkingSpot> spots) {
        return spots.stream()
                .filter(ParkingSpot::isAvailable)
                .min(Comparator.comparingInt(ParkingSpot::getDistanceToElevator))
                .orElse(null);
    }
}
