package main.java.LLD.MovieBookingApplication.models;

import main.java.LLD.MovieBookingApplication.enums.Genre;

import java.util.UUID;

public class Movie {

    private String movieId;
    private String movieName;
    private int durationInMinutes;
    private Genre genre;
    private final double moviePrice;

    public Movie(String movieName,int durationInMinutes,Genre genre,double moviePrice){
        this.movieId= UUID.randomUUID().toString();
        this.movieName=movieName;
        this.genre=genre;
        this.durationInMinutes=durationInMinutes;
        this.moviePrice=moviePrice;
    }

    public double getMoviePrice() {
        return moviePrice;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public Genre getGenre() {
        return genre;
    }
}
