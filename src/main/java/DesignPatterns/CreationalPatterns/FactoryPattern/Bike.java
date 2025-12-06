package main.java.DesignPatterns.CreationalPatterns.FactoryPattern;

public class Bike implements Transport{
    @Override
    public void deliver() {
        System.out.println("Bike delivering package");
    }
}
