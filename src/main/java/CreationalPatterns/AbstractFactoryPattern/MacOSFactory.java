package main.java.CreationalPatterns.AbstractFactoryPattern;

public class MacOSFactory implements UIFactory{
    @Override
    public Button render() {
        return new MacOSButton();
    }

    @Override
    public ScrollBar scrollBar() {
        return new MacOSScrollBar();
    }
}
