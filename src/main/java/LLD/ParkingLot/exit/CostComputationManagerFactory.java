package main.java.LLD.ParkingLot.exit;

import main.java.LLD.ParkingLot.exit.models.Ticket;
import main.java.LLD.ParkingLot.exit.services.PaymentService;
import main.java.LLD.ParkingLot.exit.strategyPattern.PerHourCostStrategy;
import main.java.LLD.ParkingLot.exit.strategyPattern.PerMinuteCostStrategy;
import main.java.LLD.ParkingLot.exit.templatePattern.CostComputationManager;
import main.java.LLD.ParkingLot.exit.templatePattern.FourWheelerCostComputationManager;
import main.java.LLD.ParkingLot.exit.templatePattern.TwoWheelerCostComputationManager;

public class CostComputationManagerFactory {

    public static CostComputationManager getCostComputationManager(Ticket ticket, PaymentService paymentService){
        return switch (ticket.getVehicle().getVehicleType()){
            case TWO_WHEELER -> new TwoWheelerCostComputationManager(new PerMinuteCostStrategy());
            case FOUR_WHEELER -> new FourWheelerCostComputationManager(new PerHourCostStrategy());
        };
    }
}
