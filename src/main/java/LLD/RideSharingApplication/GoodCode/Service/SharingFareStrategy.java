package main.java.LLD.RideSharingApplication.GoodCode.Service;

import main.java.LLD.RideSharingApplication.GoodCode.Models.Vehicle;

public class SharingFareStrategy implements FareStrategy{
    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.pricePerKm()*distance*.5;
    }
}
