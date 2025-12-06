package main.java.LLD.RideSharingApplication.GoodCode;

import main.java.LLD.RideSharingApplication.GoodCode.Models.Car;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Driver;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Location;
import main.java.LLD.RideSharingApplication.GoodCode.Models.Passenger;
import main.java.LLD.RideSharingApplication.GoodCode.Service.MatchingService;
import main.java.LLD.RideSharingApplication.GoodCode.Service.RideSharingService;
import main.java.LLD.RideSharingApplication.GoodCode.Service.StandardFareStrategy;
import main.java.LLD.RideSharingApplication.GoodCode.UsersRepository.UserRepository;

public class RideSharingApplication {

    public static void main(String[] args){

        Location l1 = new Location(11.354,12.1324);
        Location l2 = new Location(8.354,7.1324);
        Location l3 = new Location(9.354,9.1324);
        Location l4 = new Location(15.354,16.1324);
        Location destination = new Location(20.354,21);

        Driver d1 = new Driver("Girdhar","Male",new Car("Swift","UP2021"),l1);
        Driver d2 = new Driver("Abhishek","Male",new Car("WagonR","UP2025"),l2);
        Driver d3 = new Driver("Jatin","Male",new Car("Amaze","UP1998"),l3);
        UserRepository repository = new UserRepository();
        repository.addDrivers(d1);
        repository.addDrivers(d2);
        repository.addDrivers(d3);


        Passenger p1 = new Passenger("Dhruv","Male",l4);
        repository.addPassengers(p1);

        RideSharingService rideSharingService = new RideSharingService(new MatchingService(repository),new StandardFareStrategy());
        rideSharingService.bookRide(p1,destination);


    }
}
