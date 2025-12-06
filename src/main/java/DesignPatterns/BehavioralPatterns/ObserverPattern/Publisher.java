package main.java.DesignPatterns.BehavioralPatterns.ObserverPattern;

interface Publisher {

    void addObservers(DeviceObserver deviceObserver);

    void removeObserver(DeviceObserver deviceObserver);

    void notifyAllObservers();
}
