package main.java.LLD.RateLimiter;

import main.java.LLD.RateLimiter.models.Tier;
import main.java.LLD.RateLimiter.models.UserRequest;
import main.java.LLD.RateLimiter.service.RateLimiterService;
import main.java.LLD.RateLimiter.service.factory.RateLimiterFactory;

public class Main {

    public static void main(String[] args){
        RateLimiterService service = new RateLimiterService(new RateLimiterFactory());
        UserRequest request = new UserRequest("DH123", Tier.FREE);
        for(int i=0;i<10;i++){
            System.out.println("Is User Request Allowed: "+ service.allowRequests(request));
        }
    }
}
