package main.java.LLD.RideSharingApplication.GoodCode.Service;

import main.java.LLD.RideSharingApplication.GoodCode.Models.Vehicle;

public interface FareStrategy {

    public double calculateFare(Vehicle vehicle,double distance);
}
