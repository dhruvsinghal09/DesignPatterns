package main.java.LLD.MovieBookingApplication.models;

import main.java.LLD.MovieBookingApplication.enums.SeatStatus;
import main.java.LLD.MovieBookingApplication.enums.SeatType;

import java.util.UUID;

public class Seat {

    private String seatId;
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus status;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatId = UUID.randomUUID().toString();
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.status= SeatStatus.AVAILABLE;
    }

    public void setStatus(SeatStatus status){
        this.status=status;
    }

    public SeatStatus getStatus(){
        return status;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType=" + seatType +
                ", status=" + status +
                '}';
    }

    @Override
    public int hashCode() {
        return this.seatId.hashCode();
    }
}
