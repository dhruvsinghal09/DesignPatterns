package main.java.LLD.ElevatorSystem;

public class ElevatorCar {

    private final int id;
    private Direction direction;
    private Status status;
    private InternalButton internalButton;
    private Display display;
    private int floor;

    public ElevatorCar(int id) {
        this.id=id;
        this.status=Status.IDLE;
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public void setInternalButton(InternalButton internalButton) {
        this.internalButton = internalButton;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void move(int floor,Direction direction){
        System.out.println("Current floor of elevator " + getFloor() + " and direction " + getDirection().name());
        this.floor=floor;
        this.direction=direction;
        System.out.println("Elevator Moving to floor " + floor + " and direction " + direction.name());
    }
}
