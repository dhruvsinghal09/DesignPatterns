package main.java.LLD.ElevatorSystem;

public class InternalButton {

    private final InternalButtonDispatcher internalButtonDispatcher;

    private ElevatorCar elevatorCar;

    public InternalButton(InternalButtonDispatcher internalButtonDispatcher){
        this.internalButtonDispatcher=internalButtonDispatcher;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public void pressButton(int floor, Direction direction) {
        internalButtonDispatcher.submitRequest(floor,direction, elevatorCar.getId());
    }
}
