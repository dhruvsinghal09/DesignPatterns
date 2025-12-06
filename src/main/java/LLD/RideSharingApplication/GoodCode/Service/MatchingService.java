package main.java.LLD.RideSharingApplication.GoodCode.Service;

import main.java.LLD.RideSharingApplication.GoodCode.Enums.Status;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Driver;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Passenger;
import main.java.LLD.RideSharingApplication.GoodCode.UsersRepository.UserRepository;

import java.util.List;

public class MatchingService {

    private UserRepository userRepository;

    public MatchingService(UserRepository repository){
        this.userRepository=repository;
    }

    public Driver nearestDriver(Passenger p1){
        List<Driver> drivers = userRepository.getDrivers();
        double minDist = Double.MAX_VALUE;
        Driver assignedDriver=null;
        for(Driver driver:drivers){
            if(driver.getStatus().equals(Status.AVAILABLE)){
                double minDistance = driver.getLocation().distanceTo(p1.getLocation());
                if(minDistance<minDist){
                    minDist=minDistance;
                    assignedDriver=driver;
                }
            }
        }
        return assignedDriver;

    }

    public void updateDriverStatus(Driver driver, Status status){
        userRepository.updateDriverStatus(driver,status);
    }
}
