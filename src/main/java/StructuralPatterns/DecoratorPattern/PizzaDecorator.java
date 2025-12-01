package main.java.StructuralPatterns.DecoratorPattern;

abstract class PizzaDecorator implements Pizza{

    private Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza=pizza;
    }

    public String getDescription(){
        return pizza.getDescription();
    }

    public double getCost(){
        return pizza.getCost();
    }
}
