package main.java.StructuralPatterns.ProxyPattern;

public class Main {

    public static void main(String[] args){
        Image proxyImage = new ProxyImage("dhruv.png");
        proxyImage.display();
        proxyImage.display();
    }
}
