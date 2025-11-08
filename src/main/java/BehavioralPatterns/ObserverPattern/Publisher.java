package main.java.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface Publisher {

    void addObservers(DeviceObserver deviceObserver);

    void removeObserver(DeviceObserver deviceObserver);

    void notifyAllObservers();
}
