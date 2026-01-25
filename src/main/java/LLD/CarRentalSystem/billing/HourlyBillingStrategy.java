package main.java.LLD.CarRentalSystem.billing;

import main.java.LLD.CarRentalSystem.reservation.Reservation;
import main.java.LLD.CarRentalSystem.vehicleInventory.Vehicle;
import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleInventoryManager;

import java.time.Duration;

public class HourlyBillingStrategy implements BillingStrategy{


    private final VehicleInventoryManager vehicleInventoryManager;

    public HourlyBillingStrategy(VehicleInventoryManager vehicleInventoryManager){
        this.vehicleInventoryManager=vehicleInventoryManager;
    }

    @Override
    public Bill generateBill(Reservation r) {
        int vehicleId = r.getVehicleId();
        Vehicle vehicle = vehicleInventoryManager.getVehicle(vehicleId);
        if(vehicle==null)
            throw new RuntimeException("This Vehicle Doesn't exists");
        int cost = vehicle.getDailyRentRate();
        double perHour = (double)cost/24;
        long hours = Duration.between(r.getFrom().toInstant(),r.getTo().toInstant()).toHours()+1;
        double finalCost = hours*perHour;
        return new Bill(billIds.getAndIncrement(),r.getReservationId(),finalCost);
    }
}
