package main.java.BehavioralPatterns.ObserverPattern;

public class ObserverMain {

    public static void main(String[] args){
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObservers(new LaptopDevice());
        weatherStation.addObservers(new MobileDevice());
        weatherStation.setTemp(100);
    }
}
