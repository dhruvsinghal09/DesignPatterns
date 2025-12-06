package main.java.LLD.RideSharingApplication.GoodCode.Models;

import main.java.LLD.RideSharingApplication.GoodCode.Models.Location;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Vehicle;
import main.java.LLD.RideSharingApplication.GoodCode.Enums.Status;

public class Driver extends User implements Notify{

    private Vehicle vehicle;

    private Status status;

    public Driver(String name, String gender, Vehicle vehicle, Location location) {
        super(name, gender,location);
        this.vehicle = vehicle;
        this.status=Status.AVAILABLE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getLocation() {
        return super.getLocation();
    }

    public void setLocation(Location location) {
        super.setLocation(location);
    }

    @Override
    public void notify(String msg) {
        System.out.println("Driver " + msg);
    }
}
