package main.java.LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalButtonDispatcher {

    private Map<Integer,ElevatorController> elevatorControllers;

    public InternalButtonDispatcher(){
        this.elevatorControllers=new HashMap<>();
    }

    public void addElevatorController(ElevatorController elevatorController){
        elevatorControllers.put(elevatorController.getElevatorCar().getId(),elevatorController);
    }

    public void submitRequest(int floor,Direction direction,int liftId){
        ElevatorController elevatorController = elevatorControllers.get(liftId);
        elevatorController.submitRequest(floor,direction);
    }
}
