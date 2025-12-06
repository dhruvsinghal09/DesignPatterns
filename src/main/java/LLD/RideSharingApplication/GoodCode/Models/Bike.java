package main.java.LLD.RideSharingApplication.GoodCode.Models;

public class Bike extends Vehicle{
    public Bike(String name, String number) {
        super(name, number);
    }

    @Override
    public double pricePerKm() {
        return 8;
    }
}
