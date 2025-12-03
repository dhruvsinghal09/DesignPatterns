package main.java.StructuralPatterns.FacadePattern;

public class APIGatewayFacade {

    private UserService userService;
    private OrderService orderService;
    private PaymentService paymentService;

    public APIGatewayFacade(){
        userService=new UserService();
        orderService=new OrderService();
        paymentService=new PaymentService();
    }

    public String initiatePayment(String name,String orderId,String payment){
        return userService.getUser(name) + "\n" + orderService.getOrders(orderId) + "\n"
                + paymentService.processPayment(payment);
    }
}
