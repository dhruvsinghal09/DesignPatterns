package main.java.CreationalPatterns.FactoryPattern;

public class Bus implements Transport{
    @Override
    public void deliver() {
        System.out.println("Bus delivering package");
    }
}
