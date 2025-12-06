package main.java.DesignPatterns.BehavioralPatterns.MementoPattern;

import java.util.Stack;

public class History {

    private Stack<EditorMemento> history;

    public History(){
        history=new Stack<>();
    }

    public void saveHistory(TextEditor editor){
        history.push(editor.saveState());
    }

    public void undoHistory(TextEditor editor){
        if(!history.isEmpty()){
            history.pop();
            if(history.isEmpty()){
                editor.restore(new EditorMemento(""));
                return;
            }
            editor.restore(history.peek());
        }else{
            System.out.println("The editor has no history");
        }
    }
}
