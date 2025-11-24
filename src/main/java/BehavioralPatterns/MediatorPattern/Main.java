package main.java.BehavioralPatterns.MediatorPattern;

public class Main {

    public static void main(String[] args){
        ChatRoom chatRoom = new ChatRoom();
        User u1 = new User("Dhruv",chatRoom);
        User u2 = new User("Himanshu",chatRoom);
        User u3 = new User("Suraj",chatRoom);
        User u4 = new User("Vikram",chatRoom);
        User u5 = new User("Neetesh",chatRoom);
        chatRoom.addUser(u1);
        chatRoom.addUser(u2);
        chatRoom.addUser(u3);
        chatRoom.addUser(u4);
        chatRoom.addUser(u5);
        chatRoom.sendMessage("Hi Everyone!",u1);
    }
}
