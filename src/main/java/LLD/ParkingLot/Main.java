package main.java.LLD.ParkingLot;

import main.java.LLD.ParkingLot.entrance.*;
import main.java.LLD.ParkingLot.entrance.templatePattern.ParkingSpotManager;
import main.java.LLD.ParkingLot.entrance.models.ParkingSpot;
import main.java.LLD.ParkingLot.entrance.models.Vehicle;
import main.java.LLD.ParkingLot.entrance.models.VehicleType;
import main.java.LLD.ParkingLot.exit.Exit;
import main.java.LLD.ParkingLot.exit.templatePattern.CostComputationManager;
import main.java.LLD.ParkingLot.exit.CostComputationManagerFactory;
import main.java.LLD.ParkingLot.exit.services.PaymentService;
import main.java.LLD.ParkingLot.exit.models.Ticket;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Created two different vehicles bike and car
        Vehicle bike = new Vehicle("UP1520", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("UP0007",VehicleType.FOUR_WHEELER);

        //Created few parking spots
        ParkingSpot p1 = new ParkingSpot(10);
        ParkingSpot p2 = new ParkingSpot(14);
        ParkingSpot p3 = new ParkingSpot(18);
        ParkingSpot p4 = new ParkingSpot(21);
        ParkingSpot p5 = new ParkingSpot(24);
        ParkingSpot p6 = new ParkingSpot(27);

        //Got the ParkingManager for the given VehicleType from the Factory
        ParkingSpotManager pm = ParkingSpotManagerFactory.getParkingSpotManager(bike, List.of(p1,p2,p3,p4,p5,p6));


        Entrance entrance = new Entrance(pm);

        //ParkingManager assigned the space to the vehicle on the Entry Gate
        ParkingSpot parkingSpot = entrance.assignSpace(bike);
        System.out.println(parkingSpot.getSpotId() + " cost is: " + parkingSpot.getCost());

        //Generated the ticket for the Vehicle
        Ticket ticket = new Ticket(bike,parkingSpot);
        System.out.println(ticket.getParkingSpot().isAvailable());
        Thread.sleep(1000);

        //Got the CostComputationManager for the given VehicleType from the Factory
        CostComputationManager costComputationManager = CostComputationManagerFactory.getCostComputationManager(ticket,new PaymentService());

        Exit exit = new Exit(costComputationManager,new PaymentService());

        //CostManager calculate the ticket price on the Exit Gate
        double price = exit.getCost(ticket);

        System.out.println("Amount to be paid for ticket " + ticket.getTicketId() + " is " + price);

        //ticket payment
        exit.makePayment(ticket);

        //After successful payment, spot is again available
        System.out.println(ticket.getParkingSpot().isAvailable());

    }
}
