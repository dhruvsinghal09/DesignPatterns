package main.java.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

abstract class Publisher {

    private List<DeviceObserver> observers;

    Publisher() {
        this.observers = new ArrayList<>();
    }

    public void addObservers(DeviceObserver deviceObserver){
        observers.add(deviceObserver);
    }

    public void removeObserver(DeviceObserver deviceObserver){
        observers.remove(deviceObserver);
    }

    public void notifyAllObservers(double temp){
        observers.parallelStream()
                .forEach(deviceObserver -> deviceObserver.update(temp));
    }
}
