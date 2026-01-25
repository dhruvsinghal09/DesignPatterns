package main.java.LLD.CarRentalSystem.rentalStores;

import main.java.LLD.CarRentalSystem.billing.Bill;
import main.java.LLD.CarRentalSystem.billing.BillingManager;
import main.java.LLD.CarRentalSystem.payment.PaymentService;
import main.java.LLD.CarRentalSystem.reservation.Reservation;
import main.java.LLD.CarRentalSystem.reservation.ReservationManager;
import main.java.LLD.CarRentalSystem.reservation.ReservationType;
import main.java.LLD.CarRentalSystem.vehicleInventory.Vehicle;
import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleInventoryManager;
import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleType;
import main.java.LLD.CarRentalSystem.users.Location;

import java.util.Date;
import java.util.List;

public class CarRentalStore {

    private final int storeId;
    private Location location;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillingManager billingManager;
    private final PaymentService paymentService;

    public CarRentalStore(int storeId,Location location,VehicleInventoryManager vehicleInventoryManager, ReservationManager reservationManager, BillingManager billingManager, PaymentService paymentService) {
        this.storeId=storeId;
        this.location=location;
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationManager = reservationManager;
        this.billingManager = billingManager;
        this.paymentService = paymentService;
    }

    public int getStoreId() {
        return storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Vehicle> getVehicles(VehicleType type, Date from, Date to){
        List<Vehicle> vehicles = vehicleInventoryManager.getAvailableVehicles(type,from,to);
        if(vehicles==null || vehicles.isEmpty())
            throw new RuntimeException("No Vahicles available of type " + type.name());
        return vehicles;
    }

    public Reservation createReservation(int vehicleId, int userId, Date from, Date to, ReservationType type){
        return reservationManager.createReservation(vehicleId,userId,from,to,type);
    }

    public Bill generateBill(int reservationId){
        Reservation reservation = reservationManager.findById(reservationId);
        return billingManager.generateBill(reservation);
    }

    public boolean makePayment(Bill bill){
        return paymentService.pay(bill);
    }

    public void startTrip(int reservationId){
        reservationManager.startTrip(reservationId);
    }

    public void endTrip(int reservationId){
        reservationManager.endTrip(reservationId);
    }
}
