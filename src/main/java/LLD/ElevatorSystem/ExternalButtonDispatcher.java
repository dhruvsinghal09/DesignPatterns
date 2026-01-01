package main.java.LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ExternalButtonDispatcher {

    private List<ElevatorController> elevatorControllers;
    private LiftDispatchStrategy strategy;

    public ExternalButtonDispatcher(LiftDispatchStrategy strategy) {
        this.elevatorControllers = new ArrayList<>();
        this.strategy = strategy;
    }

    public void addElevatorController(ElevatorController elevatorController) {
        elevatorControllers.add(elevatorController);
    }

    public void submitRequest(int floor, Direction direction) {
        ElevatorController elevatorController = strategy.getElevatorController(floor, direction, elevatorControllers);
        elevatorController.submitRequest(floor, direction);
    }
}
