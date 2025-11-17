package main.java.BehavioralPatterns.CommandPattern;

public class UnderlineCommand implements Command{

    private TextEditor textEditor;

    public UnderlineCommand(TextEditor textEditor){
        this.textEditor=textEditor;
    }

    @Override
    public void execute() {
        textEditor.makeUnderline();
    }
}
