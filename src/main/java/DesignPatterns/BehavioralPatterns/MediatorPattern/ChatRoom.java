package main.java.DesignPatterns.BehavioralPatterns.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {

    private List<User> users;

    public ChatRoom(){
        users=new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User sender) {
        for(User user:users){
            if(user!=sender){
                user.receivingMessage(message,sender);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
