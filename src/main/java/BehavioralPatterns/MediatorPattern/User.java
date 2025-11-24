package main.java.BehavioralPatterns.MediatorPattern;

import java.util.UUID;

public class User {

    private String id;
    private String name;
    private ChatRoom chatRoom;

    public User(String name,ChatRoom chatRoom){
        this.id = UUID.randomUUID().toString();
        this.name=name;
        this.chatRoom=chatRoom;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public void sendMessage(String message){
        System.out.println(this.name + " sending message " + message);
        chatRoom.sendMessage(message,this);
    }

    public void receivingMessage(String message, User sender){
        System.out.println("Message received " + message + " for user " + this.name + " by " + sender.name);
    }
}
