package main.java.BehavioralPatterns.CommandPattern;

public class ItalicCommand implements Command{

    private TextEditor textEditor;

    public ItalicCommand(TextEditor textEditor){
        this.textEditor=textEditor;
    }

    @Override
    public void execute() {
        textEditor.makeItalic();
    }
}
