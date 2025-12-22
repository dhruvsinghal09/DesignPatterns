package main.java.LLD.ParkingLot.exit.strategyPattern;

import main.java.LLD.ParkingLot.exit.models.Ticket;

public interface CostStrategy {

    double getCost(Ticket ticket);
}
