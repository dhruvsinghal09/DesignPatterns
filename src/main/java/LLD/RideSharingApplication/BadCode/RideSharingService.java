package main.java.LLD.RideSharingApplication.BadCode;

import java.util.ArrayList;
import java.util.List;

public class RideSharingService {

    private List<Driver> drivers = new ArrayList<>();

    private List<Passenger> passengers = new ArrayList<>();

    private static final double EARTH_RADIUS = 6371.0;

    public void addPassengers(Passenger user){
        passengers.add(user);
    }

    public void addDrivers(Driver user){
        drivers.add(user);
    }

    public void bookRide(Passenger passenger, int distance){
        if(drivers.isEmpty())
            System.out.println("No Drivers Available Nearby");

        double minDist = Double.MAX_VALUE;
        Driver assignedDriver = null;
        for (Driver driver:drivers){
            double minDistance = calculateDistance(driver.getLocation(),passenger.getLocation());
            System.out.println("Minimum distance of passenger with driver "+ driver.getName() + " is " + minDistance + "km");
            if(minDistance<minDist){
                minDist=minDistance;
                assignedDriver=driver;
            }
        }
        int fare = CalculateFare(assignedDriver.getVehicle(),distance);
        System.out.println("Ride booked with driver " + assignedDriver.getName() + " and fare " + fare);
    }

    private int CalculateFare(Vehicle vehicle, int distance) {
        if(vehicle.getType().equals("CAR")){
            return 8*distance;
        }else{
            return 5*distance;
        }
    }

    private double calculateDistance(Location location, Location location1) {
        double lat1Rad = Math.toRadians(location.getLatitude());
        double lon1Rad = Math.toRadians(location.getLongitude());
        double lat2Rad = Math.toRadians(location1.getLatitude());
        double lon2Rad = Math.toRadians(location1.getLongitude());

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
