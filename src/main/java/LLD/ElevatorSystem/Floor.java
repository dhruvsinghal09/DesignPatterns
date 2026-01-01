package main.java.LLD.ElevatorSystem;

public class Floor {

    private int floorId;
    private ExternalButton externalButton;

    public Floor(int floorId,ExternalButton button){
        this.externalButton=button;
    }

    public void pressButton(int floorId,Direction direction){
        externalButton.pressButton(floorId,direction);
    }
}
