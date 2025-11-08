package main.java.BehavioralPatterns.ObserverPattern;

public class ObserverMain {

    public static void main(String[] args){
        //Publisher
        WeatherStation weatherStation = new WeatherStation();

        //Subscribers
        DeviceObserver deviceObserver = new LaptopDevice();
        DeviceObserver deviceObserver2 = new MobileDevice();

        weatherStation.addObservers(deviceObserver);
        weatherStation.addObservers(deviceObserver2);
        weatherStation.setTemp(100);
    }
}
