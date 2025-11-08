package main.java.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation extends Publisher{

    private double temp;

    public WeatherStation(){
        super();
    }

    public void setTemp(double temp){
        this.temp=temp;
        notifyAllObservers(temp);
    }
}
