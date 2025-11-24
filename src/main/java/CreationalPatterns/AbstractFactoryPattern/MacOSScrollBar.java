package main.java.CreationalPatterns.AbstractFactoryPattern;

public class MacOSScrollBar implements ScrollBar{
    @Override
    public void scrollbar() {
        System.out.println("Scrolling button for macOS");
    }
}
