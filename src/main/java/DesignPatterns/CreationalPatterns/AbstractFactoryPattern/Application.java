package main.java.DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

public class Application {

    private Button button;

    private ScrollBar scrollBar;

    public Application(UIFactory factory){
        button=factory.render();
        scrollBar=factory.scrollBar();
    }

    public Button getButton(){
        return this.button;
    }

    public ScrollBar getScrollBar(){
        return this.scrollBar;
    }
}
