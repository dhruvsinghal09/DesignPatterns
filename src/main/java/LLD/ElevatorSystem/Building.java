package main.java.LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private List<Floor> floorList;

    public Building(){
        floorList=new ArrayList<>();
    }

    public void addFloor(Floor floor){
        floorList.add(floor);
    }
}
