package main.java.LLD.CarRentalSystem.billing;

import main.java.LLD.CarRentalSystem.reservation.Reservation;

import java.util.concurrent.atomic.AtomicInteger;

public interface BillingStrategy {

    AtomicInteger billIds = new AtomicInteger(0);
    Bill generateBill(Reservation r);
}
