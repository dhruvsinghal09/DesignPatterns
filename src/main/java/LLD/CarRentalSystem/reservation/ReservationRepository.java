package main.java.LLD.CarRentalSystem.reservation;

import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {

    ConcurrentHashMap<Integer,Reservation> reservationsList;

    public ReservationRepository(){
        reservationsList=new ConcurrentHashMap<>();
    }

    public void addReservation(Reservation reservation){
        reservationsList.putIfAbsent(reservation.getReservationId(),reservation);
    }

    public Reservation findById(int reservationId){
        return reservationsList.getOrDefault(reservationId,null);
    }

    public boolean removeReservation(int reservationId){
        return reservationsList.remove(reservationId)!=null;
    }
}
