package main.java.CreationalPatterns.AbstractFactoryPattern;

public class Main {
    public static void main(String[] args){
        Application macOSApplication = new Application(new MacOSFactory());
        Button macOSButton = macOSApplication.getButton();
        ScrollBar macOSScrollBar = macOSApplication.getScrollBar();
        macOSButton.renderButton();
        macOSScrollBar.scrollbar();

        Application windowsApplication = new Application(new WindowsFactory());
        Button windowsButton = windowsApplication.getButton();
        ScrollBar windowsScrollBar = windowsApplication.getScrollBar();
        windowsButton.renderButton();
        windowsScrollBar.scrollbar();
    }
}
