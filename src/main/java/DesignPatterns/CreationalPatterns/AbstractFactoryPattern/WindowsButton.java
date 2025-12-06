package main.java.DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

public class WindowsButton implements Button{
    @Override
    public void renderButton() {
        System.out.println("rendered button for windows");
    }
}
