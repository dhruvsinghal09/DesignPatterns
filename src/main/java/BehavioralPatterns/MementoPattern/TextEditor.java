package main.java.BehavioralPatterns.MementoPattern;

public class TextEditor {

    private String content;

    public TextEditor(){
    }

    public void write(String content){
        this.content=content;
    }

    public String getContent(){
        return content;
    }

    public EditorMemento saveState(){
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento){
        content=memento.getContent();
    }
}
