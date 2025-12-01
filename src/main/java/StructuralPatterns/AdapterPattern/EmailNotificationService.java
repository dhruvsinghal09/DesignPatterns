package main.java.StructuralPatterns.AdapterPattern;

public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String to, String title, String content) {
        System.out.println("Email send to " + to + " with title " + title + " and content " + content);
    }
}
