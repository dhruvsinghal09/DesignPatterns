package main.java.StructuralPatterns.DecoratorPattern;

public class BasePizza implements Pizza{

    @Override
    public String getDescription() {
        return "This has base";
    }

    @Override
    public double getCost() {
        return 5.0;
    }

}
