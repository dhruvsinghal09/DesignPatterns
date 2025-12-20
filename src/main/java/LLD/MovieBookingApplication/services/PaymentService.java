package main.java.LLD.MovieBookingApplication.services;

import main.java.LLD.MovieBookingApplication.models.Seat;
import main.java.LLD.MovieBookingApplication.enums.SeatStatus;
import main.java.LLD.MovieBookingApplication.models.Show;

import java.util.List;

public class PaymentService {

    public double calculatePayment(Show show){
        double totalSeatPrice=0;
        double theatreSeatPrice = show.getTheatre().getSeatPrice();
        double moviePrice = show.getMovie().getMoviePrice();
        List<Seat> seats = show.getScreen().getSeats();
        for(Seat seat:seats){
            double seatPrice=(theatreSeatPrice+moviePrice)*seat.getSeatType().getPriceMultiplier();
            System.out.println("Seat " + seat.getSeatNumber() + " price: " + seatPrice);
            totalSeatPrice+=seatPrice;
        }
        return totalSeatPrice*1.18;
    }

    public void processPayment(List<Seat> seats,double bookingPrice){
        for(Seat seat:seats){
            seat.setStatus(SeatStatus.BOOKED);
            System.out.println("Seat " + seat.getSeatNumber() + " is booked.");
        }
        System.out.println("Total booking price including taxes: " + bookingPrice);

    }
}
