package main.java.CreationalPatterns.FactoryPattern;

public class Car implements Transport{
    @Override
    public void deliver() {
        System.out.println("Car delivering package");
    }
}
