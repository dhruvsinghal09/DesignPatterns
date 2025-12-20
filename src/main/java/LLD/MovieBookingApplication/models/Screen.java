package main.java.LLD.MovieBookingApplication.models;

import java.util.List;
import java.util.UUID;

public class Screen {

    private String screenId;
    private String screenName;
    private List<Seat> seats;

    public Screen(String screenName,List<Seat> seats){
        screenId= UUID.randomUUID().toString();
        this.screenName=screenName;
        this.seats=seats;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
