package main.java.CreationalPatterns.AbstractFactoryPattern;

public class MacOSButton implements Button{
    @Override
    public void renderButton() {
        System.out.println("rendered button for macOS");
    }
}
