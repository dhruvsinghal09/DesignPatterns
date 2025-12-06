package main.java.DesignPatterns.BehavioralPatterns.CommandPattern;

public class CommandPattern {

    public static void main(String[] args){
        TextEditor textEditor = new TextEditor();
        Command boldCommand = new BoldCommand(textEditor);
        Command italicCommand = new ItalicCommand(textEditor);
        Command underlineCommand = new UnderlineCommand(textEditor);
        /* decoupling i.e one button can do many type of actions */
        Button b1 = new Button();
        b1.setCommand(boldCommand);
        b1.onClick();
        b1.setCommand(italicCommand);
        b1.onClick();
        b1.setCommand(underlineCommand);
        b1.onClick();
    }
}
