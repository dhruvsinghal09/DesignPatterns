package main.java.LLD.MovieBookingApplication.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Show {

    private String showId;
    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private Theatre theatre;

    public Show(Movie movie,Screen screen, LocalDateTime startTime){
        this.showId= UUID.randomUUID().toString();
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
    }

    public void addTheatre(Theatre theatre){
        this.theatre=theatre;
    }

    public Theatre getTheatre(){
        return theatre;
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
