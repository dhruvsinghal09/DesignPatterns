package main.java.BehavioralPatterns.ObserverPattern;

public class LaptopDevice implements DeviceObserver{
    @Override
    public void update(double temp) {
        System.out.println("The updated temp for laptop is "+temp);
    }
}
