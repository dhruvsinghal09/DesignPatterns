package main.java.DesignPatterns.StructuralPatterns.DecoratorPattern;

public class CapsicumDecorator extends PizzaDecorator{
    public CapsicumDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Capsicum";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
