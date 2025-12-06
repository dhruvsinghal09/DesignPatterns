package main.java.LLD.RideSharingApplication.GoodCode.Models;

import main.java.LLD.RideSharingApplication.GoodCode.Enums.RideStatus;
import main.java.LLD.RideSharingApplication.GoodCode.Service.FareStrategy;

public class Ride {

    private Passenger passenger;
    private Driver driver;
    private FareStrategy fareStrategy;
    private double fare;
    private double distance;
    private RideStatus rideStatus;
    public Ride(Passenger passenger, Driver driver, FareStrategy fareStrategy, double distance) {
        this.passenger = passenger;
        this.driver = driver;
        this.fareStrategy = fareStrategy;
        this.distance = distance;
        this.rideStatus=RideStatus.SCHEDULED;
    }

    public void calculateFare(){
        this.fare=fareStrategy.calculateFare(driver.getVehicle(),distance);
    }

    public void notifyUsers(RideStatus status){
        this.rideStatus=status;
        passenger.notify("Ride status is "+rideStatus);
        driver.notify("Ride status is "+rideStatus);
    }

    public double getFare() {
        return fare;
    }
}
