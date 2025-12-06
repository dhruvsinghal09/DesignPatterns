package main.java.LLD.RideSharingApplication.BadCode;

public class User {

    private String name;
    private String gender;
    private Location location;

    public User(String name, String gender, Location location) {
        this.name = name;
        this.gender = gender;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
