package main.java.DesignPatterns.StructuralPatterns.DecoratorPattern;

public class Main {

    public static void main(String[] args){

        //create a basePizza
        Pizza basePizza = new BasePizza();
        //create a cheesePizza
        Pizza cheesePizza = new CheeseDecorator(basePizza);
        //create a capsicum cheese pizza
        Pizza capPizza = new CapsicumDecorator(cheesePizza);
        //create a paneer pizza with cheese capsicum toppings
        Pizza paneerPizza = new PaneerDecorator(capPizza);

        //Pizza pizza = new PaneerDecorator(new CapsicumDecorator(new CheeseDecorator(new BasePizza())));
        System.out.println(paneerPizza.getDescription());
        System.out.println(paneerPizza.getCost());
    }
}
