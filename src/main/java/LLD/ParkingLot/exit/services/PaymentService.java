package main.java.LLD.ParkingLot.exit.services;

import main.java.LLD.ParkingLot.exit.models.Ticket;

public class PaymentService {

    public void makePayment(Ticket ticket){
        System.out.println("Payment Successfully for ticketId " + ticket.getTicketId());
    }
}
