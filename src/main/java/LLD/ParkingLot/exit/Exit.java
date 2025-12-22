package main.java.LLD.ParkingLot.exit;

import main.java.LLD.ParkingLot.exit.models.Ticket;
import main.java.LLD.ParkingLot.exit.services.PaymentService;
import main.java.LLD.ParkingLot.exit.templatePattern.CostComputationManager;

public class Exit {

    private CostComputationManager costComputationManager;
    private PaymentService paymentService;

    public Exit(CostComputationManager costComputationManager, PaymentService paymentService){
        this.costComputationManager=costComputationManager;
        this.paymentService=paymentService;
    }

    public double getCost(Ticket ticket){
        return costComputationManager.getTicketPrice(ticket);
    }

    public void makePayment(Ticket ticket){
        paymentService.makePayment(ticket);
        ticket.setPaid(true);
        ticket.getParkingSpot().setAvailable(true);
        System.out.println("Ticket Amount Successfully paid for vehicle Number: "+ ticket.getVehicle().getVehicleNumber());
    }
}
