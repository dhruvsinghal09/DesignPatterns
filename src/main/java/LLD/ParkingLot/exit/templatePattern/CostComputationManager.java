package main.java.LLD.ParkingLot.exit.templatePattern;


import main.java.LLD.ParkingLot.exit.services.PaymentService;
import main.java.LLD.ParkingLot.exit.models.Ticket;
import main.java.LLD.ParkingLot.exit.strategyPattern.CostStrategy;

public abstract class CostComputationManager {

    private CostStrategy costStrategy;

    public CostComputationManager(CostStrategy costStrategy){
        this.costStrategy=costStrategy;
    }

    public double getTicketPrice(Ticket ticket){
        double cost =  costStrategy.getCost(ticket);
        System.out.println("Amount to be paid for ticket " + ticket.getTicketId() + " is " + cost);
        ticket.setAmountToPay(cost);
        return cost;
    }
}
