package main.java.DesignPatterns.BehavioralPatterns.TemplateMethodPattern;

public abstract class DataParser {

    public void parse(String parser){
        openFile();
        parser(parser);
        closeFile();
    }

    public void openFile(){
        System.out.println("file opened");
    }

    public void closeFile(){
        System.out.println("file closed");
    }

    abstract void parser(String parser);
}
