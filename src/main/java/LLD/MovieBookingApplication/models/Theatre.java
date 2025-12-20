package main.java.LLD.MovieBookingApplication.models;

import main.java.LLD.MovieBookingApplication.enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Theatre{

    private String theatreId;
    private String theatreName;
    private City city;
    private String address;
    private List<Show> shows;
    private double seatPrice;

    public Theatre(String theatreName,City city,String address, double seatPrice){
        this.theatreId= UUID.randomUUID().toString();
        this.theatreName=theatreName;
        this.city=city;
        this.address=address;
        this.shows=new ArrayList<>();
        this.seatPrice=seatPrice;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void addShow(Show show){
        shows.add(show);
        show.addTheatre(this);
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public City getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public List<Show> getShows() {
        return shows;
    }

}
