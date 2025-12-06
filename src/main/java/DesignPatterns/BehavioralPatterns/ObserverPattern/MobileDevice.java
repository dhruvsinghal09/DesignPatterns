package main.java.DesignPatterns.BehavioralPatterns.ObserverPattern;

public class MobileDevice implements DeviceObserver{
    @Override
    public void update(double temp) {
        System.out.println("The updated temp for mobile is "+temp);
    }
}
