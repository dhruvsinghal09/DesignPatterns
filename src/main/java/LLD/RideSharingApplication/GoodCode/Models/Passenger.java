package main.java.LLD.RideSharingApplication.GoodCode.Models;

public class Passenger extends User implements Notify {

    public Passenger(String name, String gender, Location location) {
        super(name, gender,location);
    }

    public Location getLocation() {
        return super.getLocation();
    }

    public void setLocation(Location location) {
        super.setLocation(location);
    }

    @Override
    public void notify(String msg) {
        System.out.println("Passenger " + msg);
    }
}
