package main.java.LLD.ElevatorSystem;

import java.util.List;

public class OddEvenLiftDispatchStrategy implements LiftDispatchStrategy {
    @Override
    public ElevatorController getElevatorController(int floor, Direction direction, List<ElevatorController> elevatorControllers) {
        System.out.println(elevatorControllers.size());
        System.out.println(elevatorControllers);
        return elevatorControllers.stream()
                .filter(elevatorController -> {
                    boolean flag = floor % 2 == 0;
                    if (flag) {
                        return elevatorController.getElevatorCar().getId() % 2 == 0;
                    } else {
                        return elevatorController.getElevatorCar().getId() % 2 != 0;
                    }
                })
                .findFirst()
                .orElse(null);
    }
}
