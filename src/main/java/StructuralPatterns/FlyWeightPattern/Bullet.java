package main.java.StructuralPatterns.FlyWeightPattern;

public class Bullet {

    private int x,y;
    private int velocity;
    private BulletType bulletType;

    public Bullet(int x,int y,int velocity,String color){
        this.x=x;
        this.y=y;
        this.velocity=velocity;
        this.bulletType=BulletTypeFactory.getBulletType(color);
        display();
    }

    private void display(){
        System.out.println("Bullet created with x and y co-ordinates as ("
                + x + "," + y + ") and color " + bulletType.color + " which is moving with velocity " + velocity);
    }

}
