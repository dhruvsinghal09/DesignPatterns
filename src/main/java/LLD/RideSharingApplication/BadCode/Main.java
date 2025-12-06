package main.java.LLD.RideSharingApplication.BadCode;

public class Main {

    public static void main(String[] args){
        Location l1 = new Location(10.2034,11.98765);
        Location l2 = new Location(15.2034,16.98765);
        Location l3 = new Location(12.2034,13.98765);

        Passenger p1 = new Passenger("Dhruv","Male",l1);

        Driver d1 = new Driver("Girdhar","Male",new Vehicle("Swift","UP1420","CAR"),l2);

        RideSharingService rideSharingService = new RideSharingService();
        rideSharingService.addDrivers(d1);
        rideSharingService.addPassengers(p1);

        rideSharingService.bookRide(p1,25);
    }
}
