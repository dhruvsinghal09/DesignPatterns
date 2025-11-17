package main.java.BehavioralPatterns.CommandPattern;

public class CommandPattern {

    public static void main(String[] args){
        TextEditor textEditor = new TextEditor();
        Command boldCommand = new BoldCommand(textEditor);
        Command italicCommand = new ItalicCommand(textEditor);
        Command underlineCommand = new UnderlineCommand(textEditor);
        Button b1 = new Button(boldCommand);
        b1.onClick();
        b1 = new Button(italicCommand);
        b1.onClick();
        b1 = new Button(underlineCommand);
        b1.onClick();
    }
}
