package main.java.DesignPatterns.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Publisher{

    List<DeviceObserver> observers;
    private double temp;

    public WeatherStation(){
        observers=new ArrayList<>();
    }

    public void setTemp(double temp){
        this.temp=temp;
        notifyAllObservers();
    }

    public void addObservers(DeviceObserver deviceObserver){
        observers.add(deviceObserver);
    }

    public void removeObserver(DeviceObserver deviceObserver){
        observers.remove(deviceObserver);
    }

    public void notifyAllObservers(){
        observers.parallelStream()
                .forEach(deviceObserver -> deviceObserver.update(temp));
    }
}
