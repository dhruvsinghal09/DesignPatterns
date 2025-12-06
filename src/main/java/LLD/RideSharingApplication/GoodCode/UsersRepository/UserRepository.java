package main.java.LLD.RideSharingApplication.GoodCode.UsersRepository;

import main.java.LLD.RideSharingApplication.GoodCode.Enums.Status;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Driver;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<Driver> drivers;

    private List<Passenger> passengers;

    public UserRepository(){
        drivers=new ArrayList<>();
        passengers=new ArrayList<>();
    }

    public void addPassengers(Passenger user){
        passengers.add(user);
    }

    public void addDrivers(Driver user){
        drivers.add(user);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void updateDriverStatus(Driver driver, Status status){
        for(Driver d:drivers){
            if(d.equals(driver)){
                d.setStatus(status);
                break;
            }
        }
    }
}
