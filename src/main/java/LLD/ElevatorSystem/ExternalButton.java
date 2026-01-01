package main.java.LLD.ElevatorSystem;

public class ExternalButton {

    private ExternalButtonDispatcher externalButtonDispatcher;

    public ExternalButton(ExternalButtonDispatcher externalButtonDispatcher){
        this.externalButtonDispatcher=externalButtonDispatcher;
    }

    public void pressButton(int floor,Direction direction){
        externalButtonDispatcher.submitRequest(floor,direction);
    }
}
