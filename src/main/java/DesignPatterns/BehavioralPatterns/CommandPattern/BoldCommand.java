package main.java.DesignPatterns.BehavioralPatterns.CommandPattern;

public class BoldCommand implements Command{

    private TextEditor textEditor;

    public BoldCommand(TextEditor textEditor){
        this.textEditor=textEditor;
    }

    @Override
    public void execute() {
        textEditor.makeBold();
    }
}
