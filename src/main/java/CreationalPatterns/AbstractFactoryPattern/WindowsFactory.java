package main.java.CreationalPatterns.AbstractFactoryPattern;

public class WindowsFactory implements UIFactory{
    @Override
    public Button render() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar scrollBar() {
        return new WindowsScrollBar();
    }
}
