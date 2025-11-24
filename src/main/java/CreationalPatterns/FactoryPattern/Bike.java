package main.java.CreationalPatterns.FactoryPattern;

public class Bike implements Transport{
    @Override
    public void deliver() {
        System.out.println("Bike delivering package");
    }
}
