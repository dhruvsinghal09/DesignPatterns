package main.java.LLD.ParkingLot.exit.strategyPattern;

import main.java.LLD.ParkingLot.exit.models.Ticket;

public class PerHourCostStrategy implements CostStrategy {
    @Override
    public double getCost(Ticket ticket) {
        long entryTime = ticket.getEntryTime();
        long currentTime = System.currentTimeMillis();
        int spotCost = ticket.getParkingSpot().getCost();
        long totalTime = (currentTime-entryTime)/1000*60*60;
        return totalTime*spotCost;
    }
}
