package main.java.DesignPatterns.StructuralPatterns.FlyWeightPattern;

public class BulletType {

    String color;

    public BulletType(String color){
        this.color=color;
        System.out.println("Bullet created with color: "+color);
    }
}
