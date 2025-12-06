package main.java.DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

public class WindowsScrollBar implements ScrollBar{
    @Override
    public void scrollbar() {
        System.out.println("Scrolling button for windows");
    }
}
