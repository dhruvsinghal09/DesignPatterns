package main.java.LLD.MovieBookingApplication.repositories;

import main.java.LLD.MovieBookingApplication.enums.City;
import main.java.LLD.MovieBookingApplication.models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {

    private HashMap<City, List<Movie>> moviesInCity;

    private List<Movie> allMovies;

    public MovieRepository(){
        moviesInCity=new HashMap<>();
        allMovies=new ArrayList<>();
    }

    public void addMovie(Movie movie,City city){
        allMovies.add(movie);
        moviesInCity.putIfAbsent(city,new ArrayList<>());
        moviesInCity.get(city).add(movie);
    }

    public List<Movie> getMoviesByCity(City city){
        return moviesInCity.getOrDefault(city,new ArrayList<>());
    }

    public List<Movie> getAllMovies(){
        return allMovies;
    }

}
