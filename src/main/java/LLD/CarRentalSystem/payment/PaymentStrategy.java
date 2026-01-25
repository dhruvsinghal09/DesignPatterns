package main.java.LLD.CarRentalSystem.payment;

import main.java.LLD.CarRentalSystem.billing.Bill;

public interface PaymentStrategy {

    boolean pay(Bill bill);
}
