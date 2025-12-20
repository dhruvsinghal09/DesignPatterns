package main.java.LLD.MovieBookingApplication.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Ticket {

    private String ticketId;
    private String movieName;
    private LocalDateTime showTime;
    private List<Seat> seats;
    private String theatreName;
    private String screenNumber;
    private double totalPrice;

    public Ticket(String movieName, LocalDateTime showTime, List<Seat> seats, String theatreName, String screenNumber,double totalPrice) {
        this.ticketId = UUID.randomUUID().toString();
        this.movieName = movieName;
        this.showTime = showTime;
        this.seats = seats;
        this.theatreName = theatreName;
        this.screenNumber = screenNumber;
        this.totalPrice=totalPrice;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public List<Seat> getSeatNumber() {
        return seats;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getScreenNumber() {
        return screenNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", showTime=" + showTime +
                ", seats=" + seats +
                ", theatreName='" + theatreName + '\'' +
                ", screenNumber='" + screenNumber + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
