package main.java.LLD.ParkingLot.exit.templatePattern;


import main.java.LLD.ParkingLot.exit.services.PaymentService;
import main.java.LLD.ParkingLot.exit.strategyPattern.CostStrategy;

public class FourWheelerCostComputationManager extends CostComputationManager{
    public FourWheelerCostComputationManager(CostStrategy costStrategy) {
        super(costStrategy);
    }
}
