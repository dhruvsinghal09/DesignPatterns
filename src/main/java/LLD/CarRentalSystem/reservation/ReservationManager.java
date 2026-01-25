package main.java.LLD.CarRentalSystem.reservation;

import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleInventoryManager;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {

    private final VehicleInventoryManager vehicleInventoryManager;

    private final ReservationRepository reservationRepository;

    private AtomicInteger reservationIds = new AtomicInteger(0);

    public ReservationManager(VehicleInventoryManager vehicleInventoryManager, ReservationRepository reservationRepository) {
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(int vehicleId, int userId, Date from, Date to, ReservationType type) {
        int reservationId = reservationIds.getAndIncrement();
        if (!vehicleInventoryManager.bookVehicle(vehicleId, reservationId, from, to)) {
            System.out.println("Vehicle not available");
            throw new RuntimeException("Vehicle not available for required dates");
        }
        Reservation reservation = new Reservation(reservationId, userId, vehicleId, from, to, type);
        System.out.println("Reservation Created for user " + userId
                + " for vehicleId " + vehicleId
                + ", Please find the reservation details " + reservation);
        reservationRepository.addReservation(reservation);
        return reservation;
    }

    public Reservation findById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public void startTrip(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);
        System.out.println("Trip started for user " + reservation.getUserId());
        reservation.setReservationStatus(ReservationStatus.IN_USE);
    }

    public void endTrip(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
        System.out.println("Trip ended for user " + reservation.getUserId());
        vehicleInventoryManager.releaseVehicle(reservation.getVehicleId(), reservationId);
    }

    public void cancelReservation(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
        vehicleInventoryManager.releaseVehicle(reservation.getVehicleId(), reservationId);
    }

    public void removeReservation(int reservationId) {
        reservationRepository.removeReservation(reservationId);
    }

}
