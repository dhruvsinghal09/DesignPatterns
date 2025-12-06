package main.java.StructuralPatterns.FlyWeightPattern;

import java.util.HashMap;

public class BulletTypeFactory {

    private static final HashMap<String,BulletType> bulletTypes = new HashMap<>();

    public static BulletType getBulletType(String color){
        return bulletTypes.computeIfAbsent(color,type-> new BulletType(color));
    }
}
