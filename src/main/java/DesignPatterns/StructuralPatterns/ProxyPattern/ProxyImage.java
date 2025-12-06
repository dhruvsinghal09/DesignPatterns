package main.java.DesignPatterns.StructuralPatterns.ProxyPattern;

public class ProxyImage implements Image{

    private String imageName;
    private RealImage realImage;

    public ProxyImage(String imageName){
        this.imageName=imageName;
    }

    @Override
    public void display() {
        if(realImage==null){
            realImage=new RealImage(imageName);
        }
        realImage.display();
    }
}
