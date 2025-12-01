package main.java.StructuralPatterns.ProxyPattern;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName=fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Image " + fileName + " Successfully loaded from disk");
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + fileName);
    }
}
