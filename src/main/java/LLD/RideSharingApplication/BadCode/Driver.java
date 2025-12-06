package main.java.LLD.RideSharingApplication.BadCode;

public class Driver extends User {

    private Vehicle vehicle;

    public Driver(String name, String gender, Vehicle vehicle, Location location) {
        super(name, gender,location);
        this.vehicle = vehicle;
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
}
