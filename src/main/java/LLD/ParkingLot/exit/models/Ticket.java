package main.java.LLD.ParkingLot.exit.models;

import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;

import java.util.UUID;

public class Ticket {

    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTime;
    private boolean paid;
    private double amountToPay;

    public Ticket(Vehicle vehicle,ParkingSpot parkingSpot){
        this.ticketId= UUID.randomUUID().toString();
        this.parkingSpot=parkingSpot;
        this.vehicle=vehicle;
        this.paid=false;
        this.entryTime=System.currentTimeMillis();
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
