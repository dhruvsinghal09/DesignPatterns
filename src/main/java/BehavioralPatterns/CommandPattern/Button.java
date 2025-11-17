package main.java.BehavioralPatterns.CommandPattern;

public class Button {

    private Command command;

    public Button(){
    }

    public void setCommand(Command command){
        this.command=command;
    }

    public void onClick(){
        command.execute();
    }
}
