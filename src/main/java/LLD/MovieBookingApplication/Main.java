package main.java.LLD.MovieBookingApplication;

import main.java.LLD.MovieBookingApplication.enums.City;
import main.java.LLD.MovieBookingApplication.enums.Genre;
import main.java.LLD.MovieBookingApplication.enums.SeatType;
import main.java.LLD.MovieBookingApplication.models.*;
import main.java.LLD.MovieBookingApplication.services.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        System.out.println("Welcome to Movie Booking Application by Dhruv Singhal");
        // create a show
        Show show = getShow();

        // create a theatre and add show to it
        Theatre wave = new Theatre("Wave Cinema", City.DELHI,"SELECT CITY MALL, DELHI",100);
        wave.addShow(show);

        // book tickets for the show
        BookingService bookingService = new BookingService();
        Ticket t1 = bookingService.bookTicket(show);
        System.out.println(t1);

        // try booking again for the same show and seats
        Ticket t2 = bookingService.bookTicket(show);
        System.out.println(t2);
    }

    private static Show getShow() {
        List<Seat> seats = new ArrayList<>();
        Seat A1 = new Seat("A"+1, SeatType.DIAMOND);
        Seat D1 = new Seat("D"+1,SeatType.GOLD);
        Seat F1 = new Seat("F"+1,SeatType.SILVER);
        seats.add(A1);
        seats.add(D1);
        seats.add(F1);
        Screen screen = new Screen("Screen 1",seats);

        Movie movie = new Movie("Dhurandhar",213, Genre.ACTION,100.0);
        Show show = new Show(movie,screen, LocalDateTime.of(
                2025, 12, 20,
                16, 0
        ));
        return show;
    }
}
