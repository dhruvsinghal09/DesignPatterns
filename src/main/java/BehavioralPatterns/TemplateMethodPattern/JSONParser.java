package main.java.BehavioralPatterns.TemplateMethodPattern;

public class JSONParser extends DataParser{
    @Override
    void parser(String parser) {
        System.out.println("parsing done for "+parser);
    }
}
