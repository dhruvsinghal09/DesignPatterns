package main.java.DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

public class MacOSScrollBar implements ScrollBar{
    @Override
    public void scrollbar() {
        System.out.println("Scrolling button for macOS");
    }
}
