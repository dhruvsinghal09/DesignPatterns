package main.java.DesignPatterns.StructuralPatterns.AdapterPattern;

public class SendGridService {

    public void sendEmail(String recipient,String subject,String body){
        System.out.println("Email send to via sendGrid " + recipient + " with title " + subject + " and content " + body);

    }
}
