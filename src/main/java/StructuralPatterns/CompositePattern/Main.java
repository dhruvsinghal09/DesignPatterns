package main.java.StructuralPatterns.CompositePattern;

public class Main {

    public static void main(String[] args){
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        Folder folder = new Folder("src");
        folder.addComponents(file1);
        folder.addComponents(file2);

        FileSystemComponent file3 = new File("file3.txt");
        Folder subFolder = new Folder("subFolder");
        subFolder.addComponents(file3);
        folder.addComponents(subFolder);
        folder.showDetails();
    }
}
