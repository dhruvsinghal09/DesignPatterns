package main.java.LLD.RideSharingApplication.BadCode;

public class Vehicle {

    private String vehicleName;
    private String vehicleNumber;
    private String type;

    public Vehicle(String vehicleName, String vehicleNumber, String type) {
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
