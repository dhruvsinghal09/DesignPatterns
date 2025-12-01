package main.java.StructuralPatterns.AdapterPattern;

public class SendGridAdapter implements NotificationService{

    private SendGridService sendGridService;
    public SendGridAdapter(SendGridService sendGridService){
        this.sendGridService=sendGridService;
    }

    @Override
    public void send(String to, String title, String content) {
        sendGridService.sendEmail(to,title,content);
    }
}
