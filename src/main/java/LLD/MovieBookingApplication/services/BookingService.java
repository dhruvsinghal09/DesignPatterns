package main.java.LLD.MovieBookingApplication.services;

import main.java.LLD.MovieBookingApplication.enums.SeatStatus;
import main.java.LLD.MovieBookingApplication.exceptions.SeatNotAvailableException;
import main.java.LLD.MovieBookingApplication.models.Screen;
import main.java.LLD.MovieBookingApplication.models.Seat;
import main.java.LLD.MovieBookingApplication.models.Show;
import main.java.LLD.MovieBookingApplication.models.Ticket;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {

    private final PaymentService paymentService;
    private static final ConcurrentHashMap<String, Object> showLocks = new ConcurrentHashMap<>();

    public BookingService() {
        paymentService = new PaymentService();
    }

    public Ticket bookTicket(Show show) {
        Screen screen = show.getScreen();
        List<Seat> seats = screen.getSeats();
        Object object = showLocks.computeIfAbsent(show.getShowId(), k -> new Object());
        synchronized ((object)) {
            for (Seat seat : seats) {
                if(seat.getStatus() != SeatStatus.AVAILABLE){
                    System.out.println("Seat with seat id " + seat.getSeatId() + " is not available");
                    throw new SeatNotAvailableException("Seat with seat id " + seat.getSeatId() + " is not available");
                }
            }
            for(Seat seat:seats){
                seat.setStatus(SeatStatus.PROCESSING);
            }
        }
        double bookingPrice = paymentService.calculatePayment(show);
        paymentService.processPayment(seats, bookingPrice);
        Ticket ticket = new Ticket(show.getMovie().getMovieName(), show.getStartTime(), seats, show.getTheatre().getTheatreName(), show.getScreen().getScreenName(),bookingPrice);
        System.out.println("Ticket successfully booked with ticket id: " + ticket.getTicketId());
        return ticket;
    }
}
