package main.java.LLD.ElevatorSystem;

import java.util.*;

public class ElevatorController {

    private ElevatorCar elevatorCar;

    private PriorityQueue<Integer> up = new PriorityQueue<>((a, b) -> a - b);
    private PriorityQueue<Integer> down = new PriorityQueue<>((a, b) -> b - a);
    private List<Integer> waitingQueue = new ArrayList<>();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void submitRequest(int floor, Direction direction) {
        if (elevatorCar.getStatus() == Status.IDLE) {
            if (direction == Direction.UP) {
                elevatorCar.setStatus(Status.MOVING);
                elevatorCar.setDirection(direction);
                up.offer(floor);
            } else {
                elevatorCar.setStatus(Status.MOVING);
                elevatorCar.setDirection(direction);
                down.offer(floor);
            }
        } else {
            if (direction == Direction.UP) {
                if (elevatorCar.getFloor() < floor) {
                    up.offer(floor);
                } else {
                    waitingQueue.add(floor);
                }
            } else {
                if (elevatorCar.getFloor() > floor) {
                    down.offer(floor);
                } else {
                    waitingQueue.add(floor);
                }
            }
        }
        controlElevator();
    }

    public void controlElevator() {
        if (elevatorCar.getStatus() == Status.IDLE) {
            System.out.println("Elevator is IDLE");
        }
        if (elevatorCar.getDirection() == Direction.UP) {
            while (!up.isEmpty()) {
                int floor = up.poll();
                elevatorCar.move(floor, Direction.UP);
            }
            up.addAll(waitingQueue);
            waitingQueue.clear();
        }
        if(elevatorCar.getDirection() == Direction.DOWN){
            while (!down.isEmpty()) {
                int floor = down.poll();
                elevatorCar.move(floor, Direction.DOWN);
            }
            down.addAll(waitingQueue);
            waitingQueue.clear();
        }
    }
}
