package main.java.LLD.CarRentalSystem;

import main.java.LLD.CarRentalSystem.billing.Bill;
import main.java.LLD.CarRentalSystem.billing.BillingManager;
import main.java.LLD.CarRentalSystem.billing.DailyBillingStrategy;
import main.java.LLD.CarRentalSystem.payment.PaymentService;
import main.java.LLD.CarRentalSystem.payment.UPI;
import main.java.LLD.CarRentalSystem.reservation.Reservation;
import main.java.LLD.CarRentalSystem.reservation.ReservationManager;
import main.java.LLD.CarRentalSystem.reservation.ReservationRepository;
import main.java.LLD.CarRentalSystem.reservation.ReservationType;
import main.java.LLD.CarRentalSystem.vehicleInventory.Vehicle;
import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleInventoryManager;
import main.java.LLD.CarRentalSystem.vehicleInventory.VehicleType;
import main.java.LLD.CarRentalSystem.rentalStores.CarRentalStore;
import main.java.LLD.CarRentalSystem.users.Location;
import main.java.LLD.CarRentalSystem.users.User;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = new User(1, "dhruvtechbyes", "DDLL1124323");
        Vehicle hondaCity = new Vehicle(123, "Honda City", "UP-15-0007", 1000, VehicleType.FOUR_WHEELER);
        Vehicle bmw = new Vehicle(234, "BMW", "UP-15-0001", 5000, VehicleType.FOUR_WHEELER);
        ReservationRepository reservationRepository = new ReservationRepository();
        VehicleInventoryManager vehicleInventoryManager = new VehicleInventoryManager(reservationRepository);
        vehicleInventoryManager.addVehicle(hondaCity);
        vehicleInventoryManager.addVehicle(bmw);

        ReservationManager reservationManager = new ReservationManager(vehicleInventoryManager, reservationRepository);

        BillingManager billingManager = new BillingManager(new DailyBillingStrategy(vehicleInventoryManager));

        PaymentService paymentService = new PaymentService(new UPI());

        CarRentalStore store = new CarRentalStore(11, new Location(12.0, 13.0), vehicleInventoryManager, reservationManager, billingManager, paymentService);
        Date from = Date.from(Instant.now());
        Date to = Date.from(Instant.now().plus(3, ChronoUnit.DAYS));
        List<Vehicle> vehicles = store.getVehicles(VehicleType.FOUR_WHEELER, from, to);

        // we will book all vehicles
        for (Vehicle vehicle : vehicles) {
            Reservation reservation = store.createReservation(vehicle.getVehicleId(), user.getUserId(), from, to, ReservationType.DAILY);
            // case to check that we can't book the same vehicle twice for same date
            //Reservation r2 = store.createReservation(vehicle.getVehicleId(), user.getUserId(), from, to, ReservationType.DAILY);
            store.startTrip(reservation.getReservationId());
            Bill bill = store.generateBill(reservation.getReservationId());
            store.endTrip(reservation.getReservationId());
            boolean payment = store.makePayment(bill);
            if (payment)
                System.out.println("Payment Successfully");
        }
    }
}
