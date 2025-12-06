package main.java.DesignPatterns.BehavioralPatterns.TemplateMethodPattern;

public class TemplateMain {

    public static void main(String[] args){
        DataParser csvParser = new CSVParser();

        DataParser jsonParser = new JSONParser();

        csvParser.parse("CSV");
        jsonParser.parse("JSON");
    }
}
