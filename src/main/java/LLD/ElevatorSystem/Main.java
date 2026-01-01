package main.java.LLD.ElevatorSystem;

public class Main {

    public static void main(String[] args){
        ElevatorCar lift1 = new ElevatorCar(1);
        ElevatorController elevatorController = new ElevatorController(lift1);
        Display display = new Display();
        InternalButtonDispatcher internalButtonDispatcher = new InternalButtonDispatcher();
        InternalButton internalButton = new InternalButton(internalButtonDispatcher);
        lift1.setDisplay(display);
        lift1.setInternalButton(internalButton);
        internalButtonDispatcher.addElevatorController(elevatorController);
        internalButton.setElevatorCar(lift1);



        ExternalButtonDispatcher externalButtonDispatcher = new ExternalButtonDispatcher(new OddEvenLiftDispatchStrategy());
        ExternalButton externalButton = new ExternalButton(externalButtonDispatcher);
        externalButtonDispatcher.addElevatorController(elevatorController);
        Floor floor1 = new Floor(1,externalButton);
        Floor floor7 = new Floor(7,externalButton);
        Floor floor5 = new Floor(5,externalButton);
        Floor floor3 = new Floor(3,externalButton);
        Building building = new Building();
        building.addFloor(floor1);
        floor1.pressButton(1,Direction.UP);
        floor5.pressButton(5,Direction.DOWN);
        floor3.pressButton(3,Direction.DOWN);
        floor7.pressButton(7,Direction.UP);
        floor1.pressButton(5,Direction.DOWN);

    }
}
