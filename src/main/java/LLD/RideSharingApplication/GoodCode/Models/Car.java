package main.java.LLD.RideSharingApplication.GoodCode.Models;

public class Car extends Vehicle{

    public Car(String name, String number) {
        super(name, number);
    }

    @Override
    public double pricePerKm() {
        return 10;
    }


}
