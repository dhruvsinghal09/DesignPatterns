package main.java.LLD.RideSharingApplication.BadCode;

public class Passenger extends User {

    public Passenger(String name, String gender, Location location) {
        super(name, gender,location);
    }

    public Location getLocation() {
        return super.getLocation();
    }

    public void setLocation(Location location) {
        super.setLocation(location);
    }
}
