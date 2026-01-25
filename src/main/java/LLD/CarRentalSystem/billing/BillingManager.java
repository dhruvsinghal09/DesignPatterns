package main.java.LLD.CarRentalSystem.billing;

import main.java.LLD.CarRentalSystem.reservation.Reservation;

import java.util.concurrent.ConcurrentHashMap;

public class BillingManager {

    private ConcurrentHashMap<Integer, Bill> bills;
    private final BillingStrategy billingStrategy;

    public BillingManager(BillingStrategy billingStrategy) {
        bills = new ConcurrentHashMap<>();
        this.billingStrategy = billingStrategy;
    }

    public Bill generateBill(Reservation r) {
        Bill bill = billingStrategy.generateBill(r);
        System.out.println("Bill generated for user " + r.getUserId()
                + ", Total Amount to be paid " + bill.getTotalBill());
        bills.putIfAbsent(bill.getBillId(), bill);
        return bills.get(bill.getBillId());
    }
}
