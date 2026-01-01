package main.java.LLD.ElevatorSystem;

import java.util.List;

public interface LiftDispatchStrategy {

    ElevatorController getElevatorController(int floor, Direction direction, List<ElevatorController> elevatorControllers);
}
