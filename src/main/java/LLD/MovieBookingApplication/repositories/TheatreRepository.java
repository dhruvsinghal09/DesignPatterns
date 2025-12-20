package main.java.LLD.MovieBookingApplication.repositories;

import main.java.LLD.MovieBookingApplication.enums.City;
import main.java.LLD.MovieBookingApplication.models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheatreRepository {

    private HashMap<City, List<Theatre>> theatresByCity;
    private List<Theatre> allTheatres;

    public TheatreRepository(){
        theatresByCity=new HashMap<>();
        allTheatres=new ArrayList<>();
    }

    public void addTheatre(Theatre theatre,City city){
        allTheatres.add(theatre);
        theatresByCity.putIfAbsent(city,new ArrayList<>());
        theatresByCity.get(city).add(theatre);
    }

    public List<Theatre> getAllTheatres(){
        return allTheatres;
    }

    public List<Theatre> getTheatresByCity(City city){
        return theatresByCity.getOrDefault(city,new ArrayList<>());
    }
}
