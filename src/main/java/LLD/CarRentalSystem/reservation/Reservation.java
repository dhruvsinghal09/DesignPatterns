package main.java.LLD.CarRentalSystem.reservation;

import java.util.Date;

public class Reservation {

    private int reservationId;
    private int userId;
    private int vehicleId;
    Date from;
    Date to;
    ReservationStatus reservationStatus;
    ReservationType reservationType;

    public Reservation(int reservationId, int userId, int vehicleId, Date from, Date to, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.from = from;
        this.to = to;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.reservationType = reservationType;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                ", from=" + from +
                ", to=" + to +
                ", reservationStatus=" + reservationStatus +
                ", reservationType=" + reservationType +
                '}';
    }
}
