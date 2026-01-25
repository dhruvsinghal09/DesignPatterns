package main.java.LLD.CarRentalSystem.billing;

import main.java.LLD.CarRentalSystem.reservation.Reservation;
import main.java.LLD.CarRentalSystem.vehicleInventory.Vehicle;
import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleInventoryManager;

import java.time.Duration;

public class DailyBillingStrategy implements BillingStrategy{

    private final VehicleInventoryManager vehicleInventoryManager;

    public DailyBillingStrategy(VehicleInventoryManager vehicleInventoryManager){
        this.vehicleInventoryManager=vehicleInventoryManager;
    }
    @Override
    public Bill generateBill(Reservation r) {
        int vehicleId = r.getVehicleId();
        Vehicle vehicle = vehicleInventoryManager.getVehicle(vehicleId);
        if(vehicle==null)
            throw new RuntimeException("This Vehicle Doesn't exists");
        int cost = vehicle.getDailyRentRate();
        long days = Duration.between(r.getFrom().toInstant(),r.getTo().toInstant()).toDays()+1;
        double finalCost = days*cost;
        return new Bill(billIds.getAndIncrement(),r.getReservationId(),finalCost);
    }
}
