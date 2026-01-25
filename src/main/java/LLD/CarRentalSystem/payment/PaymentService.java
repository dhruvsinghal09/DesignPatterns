package main.java.LLD.CarRentalSystem.payment;

import main.java.LLD.CarRentalSystem.billing.Bill;

public class PaymentService {

    private final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(Bill bill) {
        System.out.println("Payment Done for billId " + bill.getBillId()
                + " of rs " + bill.getTotalBill());
        return paymentStrategy.pay(bill);
    }
}
