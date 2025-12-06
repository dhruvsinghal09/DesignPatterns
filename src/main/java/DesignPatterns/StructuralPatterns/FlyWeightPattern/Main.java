package main.java.DesignPatterns.StructuralPatterns.FlyWeightPattern;

public class Main {

    public static void main(String[] args){
        for(int i=0;i<5;i++){
            Bullet bullet = new Bullet(i*2,i*5,100,"Red");
        }

        for(int i=0;i<5;i++){
            Bullet bullet = new Bullet(i*2,i*5,90,"Blue");
        }
    }
}
