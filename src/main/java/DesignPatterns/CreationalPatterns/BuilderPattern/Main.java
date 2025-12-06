package main.java.DesignPatterns.CreationalPatterns.BuilderPattern;

public class Main {

    public static void main(String[] args){
        Flat flat = new Flat.FlatBuilder("Dhruv",
                "area",
                "chapprauli banger",
                "sector 168",
                "Noida",
                "Uttar Pradesh")
                .setFacing("eastFacing")
                .setHasBalcony(true)
                .setHasStoreRoom(false)
                .setHasParking(true)
                .setLandmark("near paras seaons")
                .build();
        System.out.println(flat);
    }
}
