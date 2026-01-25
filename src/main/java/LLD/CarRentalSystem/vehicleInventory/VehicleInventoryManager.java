package main.java.LLD.CarRentalSystem.vehicleInventory;

import main.java.LLD.CarRentalSystem.reservation.Reservation;
import main.java.LLD.CarRentalSystem.reservation.ReservationRepository;
import main.java.LLD.CarRentalSystem.reservation.ReservationStatus;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleInventoryManager {

    private ConcurrentHashMap<Integer,Vehicle> vehiclesList;

    private ReservationRepository reservationRepository;

    private ConcurrentHashMap<Integer, List<Integer>> vehicleReservations;

    private ConcurrentHashMap<Integer, ReentrantLock> lockOnVehicle;

    public VehicleInventoryManager(ReservationRepository reservationRepository) {
        vehiclesList=new ConcurrentHashMap<>();
        this.reservationRepository=reservationRepository;
        vehicleReservations=new ConcurrentHashMap<>();
        lockOnVehicle=new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehiclesList.putIfAbsent(vehicle.getVehicleId(),vehicle);
    }

    public Vehicle getVehicle(int vehicleId){
        return vehiclesList.get(vehicleId);
    }

    public boolean removeVehicle(int vehicleId){
        return vehiclesList.remove(vehicleId)!=null;
    }

    public boolean isVehicleAvailable(int vehicleId, Date from, Date to){
        Vehicle vehicle = vehiclesList.get(vehicleId);
        if(vehicle==null || vehicle.getVehicleStatus()==VehicleStatus.MAINTAINANCE)
            return false;
        List<Integer> reservationIds = vehicleReservations.get(vehicleId);
        if(reservationIds==null)
            return true;
        for(int reservationId:reservationIds){
            Reservation reservation = reservationRepository.findById(reservationId);
            Date bookedFrom = reservation.getFrom();
            Date bookedTo = reservation.getTo();
            if(!bookedFrom.after(to) && !from.after(bookedTo))
                return false;
        }
        return true;
    }

    public boolean bookVehicle(int vehicleId,int reservationId, Date from,Date to){
        ReentrantLock vehicleLock = getLockOnVehicle(vehicleId);
        vehicleLock.lock();
        try{
            if(!isVehicleAvailable(vehicleId,from,to))
                return false;
            vehicleReservations.computeIfAbsent(vehicleId,k->new ArrayList<>()).add(reservationId);
            vehiclesList.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
        }finally {
            vehicleLock.unlock();
        }
        return true;
    }

    public void releaseVehicle(int vehicleId,int reservationId){
        ReentrantLock vehicleLock = getLockOnVehicle(vehicleId);
        vehicleLock.lock();
        try{
            List<Integer> reservationIds = vehicleReservations.get(vehicleId);
            if(reservationIds!=null)
                reservationIds.remove(Integer.valueOf(reservationId));
            Reservation reservation = reservationRepository.findById(reservationId);
            reservation.setReservationStatus(ReservationStatus.COMPLETED);
            vehiclesList.get(vehicleId).setVehicleStatus(VehicleStatus.AVAILABLE);
        }finally {
            vehicleLock.unlock();
        }
    }

    public List<Vehicle> getAvailableVehicles(VehicleType type,Date from,Date to){
        return vehiclesList.values()
                .stream()
                .filter(vehicle -> vehicle.getVehicleType()==type)
                .filter(vehicle -> isVehicleAvailable(vehicle.getVehicleId(),from,to))
                .toList();
    }

    private ReentrantLock getLockOnVehicle(int vehicleId){
        lockOnVehicle.putIfAbsent(vehicleId,new ReentrantLock());
        return lockOnVehicle.get(vehicleId);
    }
}
