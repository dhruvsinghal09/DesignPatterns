package main.java.BehavioralPatterns.MementoPattern;

public class MainEditor {

    public static void main(String[] args){
        History history = new History();
        TextEditor editor = new TextEditor();
        editor.write("Hi !");
        history.saveHistory(editor);
        editor.write("My name is Dhruv Singhal");
        history.saveHistory(editor);
        history.undoHistory(editor);
        System.out.println(editor.getContent());
    }
}
