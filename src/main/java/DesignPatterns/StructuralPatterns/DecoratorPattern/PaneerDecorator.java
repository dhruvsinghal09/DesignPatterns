package main.java.DesignPatterns.StructuralPatterns.DecoratorPattern;

public class PaneerDecorator extends PizzaDecorator{
    public PaneerDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Paneer";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0;
    }
}
