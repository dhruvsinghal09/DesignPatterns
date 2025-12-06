package main.java.DesignPatterns.CreationalPatterns.FactoryPattern;

public class Car implements Transport{
    @Override
    public void deliver() {
        System.out.println("Car delivering package");
    }
}
