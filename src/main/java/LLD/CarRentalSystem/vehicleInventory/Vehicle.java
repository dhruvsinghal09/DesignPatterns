package main.java.LLD.CarRentalSystem.vehicleInventory;

public class Vehicle {
    private int vehicleId;
    private String vehicleName;
    private String vehicleNumber;
    private int dailyRentRate;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;

    public Vehicle(int vehicleId, String vehicleName, String vehicleNumber, int dailyRentRate, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.dailyRentRate = dailyRentRate;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public int getVehicleId() {
        return vehicleId;
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

    public int getDailyRentRate() {
        return dailyRentRate;
    }

    public void setDailyRentRate(int dailyRentRate) {
        this.dailyRentRate = dailyRentRate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
