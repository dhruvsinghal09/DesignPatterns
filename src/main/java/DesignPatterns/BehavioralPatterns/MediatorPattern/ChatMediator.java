package main.java.DesignPatterns.BehavioralPatterns.MediatorPattern;

public interface ChatMediator {

    void sendMessage(String message,User user);

    void addUser(User user);
}
