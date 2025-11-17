package main.java.BehavioralPatterns.CommandPattern;

public class Button {

    private Command command;

    public Button(Command command){
        this.command=command;
    }

    public void onClick(){
        command.execute();
    }
}
