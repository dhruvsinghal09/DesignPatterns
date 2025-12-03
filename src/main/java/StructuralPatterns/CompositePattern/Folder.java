package main.java.StructuralPatterns.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{

    private String name;

    private List<FileSystemComponent> components;

    public Folder(String name){
        this.name=name;
        this.components=new ArrayList<>();
    }

    public void addComponents(FileSystemComponent component){
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder is: "+name);
        components.forEach(FileSystemComponent::showDetails);
    }
}
