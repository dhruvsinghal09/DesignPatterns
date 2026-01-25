package main.java.LLD.CarRentalSystem.payment;

import main.java.LLD.CarRentalSystem.billing.Bill;

public class UPI implements PaymentStrategy{
    @Override
    public boolean pay(Bill bill) {
        return true;
    }
}
