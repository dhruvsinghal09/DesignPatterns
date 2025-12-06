package main.java.LLD.RideSharingApplication.GoodCode.Service;

import main.java.LLD.RideSharingApplication.GoodCode.Enums.RideStatus;
import main.java.LLD.RideSharingApplication.GoodCode.Enums.Status;
import main.java.LLD.RideSharingApplication.GoodCode.Models.*;

public class RideSharingService {

    private MatchingService matchingService;


    private FareStrategy fareStrategy;


    public RideSharingService(MatchingService matchingService,FareStrategy fareStrategy){
        this.matchingService=matchingService;
        this.fareStrategy=fareStrategy;
    }

    public void bookRide(Passenger p1, Location destination){
        Driver driver = matchingService.nearestDriver(p1);
        if(driver==null){
            p1.notify("Drivers not available");
            return;
        }
        double distance = p1.getLocation().distanceTo(destination);
        Ride ride = new Ride(p1,driver,fareStrategy,distance);
        ride.calculateFare();
        double fare = ride.getFare();
        matchingService.updateDriverStatus(driver, Status.BOOKED);

        p1.notify("Ride booked and the driver details are:- " + "\n"
                + "Driver Name " + driver.getName() + "\n"
                + "Vehicle Name " + driver.getVehicle().getName() + "\n"
                + "Vehicle Number " + driver.getVehicle().getNumber() + "\n"
                + "and estimated fare will be " + fare);

        // Notify users about ride status when started
        ride.notifyUsers(RideStatus.ON_GOING);


        // Notify users about ride status when completed
        ride.notifyUsers(RideStatus.COMPLETED);
        matchingService.updateDriverStatus(driver, Status.AVAILABLE);



    }
}
