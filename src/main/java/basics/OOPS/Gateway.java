package main.java.basics.OOPS;

public class Gateway {

    public static void main(String[] args){
        PaymentService paymentService = new PaymentService();
        paymentService.addPaymentMethod("DhruvCC",new CreditCard("551122","Dhruv Singhal"));
        paymentService.addPaymentMethod("DhruvDC",new DebitCard("12345","Dhruv Singhal"));
        paymentService.addPaymentMethod("DhruvUPI",new UPI("98765","Dhruv Singhal"));
        paymentService.addPaymentMethod("DhruvWallet",new Wallet("43112","Dhruv Singhal"));

        paymentService.makePayment("DhruvCC");
        paymentService.makePayment("DhruvDC");
        paymentService.makePayment("DhruvUPI");
        paymentService.makePayment("DhruvWallet");
        paymentService.deletePaymentMethod("DhruvWallet");

    }
}
