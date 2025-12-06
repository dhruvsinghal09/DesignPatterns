package main.java.DesignPatterns.StructuralPatterns.CompositePattern;

public class File implements FileSystemComponent{

    private String name;

    public File(String name){
        this.name=name;
    }

    @Override
    public void showDetails() {
        System.out.println("File name is: "+name);
    }
}
