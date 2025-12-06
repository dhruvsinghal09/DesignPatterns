package main.java.DesignPatterns.StructuralPatterns.AdapterPattern;

public class Client {

    public static void main(String[] args){
        NotificationService notificationService = new EmailNotificationService();
        notificationService.send("dhruv@gmail.com","my adapter pattern","Content is fun");


        //Integrating SendGridService having different structure with same interface i.e NotificationService
        NotificationService sendGridService = new SendGridAdapter(new SendGridService());
        sendGridService.send("dhruv@gmail.com","my adapter pattern","Content is fun");

        //integrated 2 different classes with same interface and removed complexity.
    }
}
