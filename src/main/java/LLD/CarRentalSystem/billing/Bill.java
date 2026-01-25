package main.java.LLD.CarRentalSystem.billing;

public class Bill {

    private int billId;
    private int reservationId;
    private double totalBill;
    private boolean isPaid;

    public Bill(int billId, int reservationId, double totalBill) {
        this.billId = billId;
        this.reservationId = reservationId;
        this.totalBill = totalBill;
        this.isPaid = false;
    }

    public int getBillId() {
        return billId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
