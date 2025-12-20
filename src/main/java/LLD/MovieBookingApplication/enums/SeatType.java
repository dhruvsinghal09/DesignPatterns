package main.java.LLD.MovieBookingApplication.enums;


public enum SeatType {

    DIAMOND(2),
    GOLD(1.5),
    SILVER(1);

    private final double priceMultiplier;

    SeatType(double priceMultiplier){
        this.priceMultiplier=priceMultiplier;
    }


    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
