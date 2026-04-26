package main.java.LLD.RateLimiter.service;

import main.java.LLD.RateLimiter.service.factory.RateLimiterFactory;
import main.java.LLD.RateLimiter.service.strategy.RateLimiterStrategy;
import main.java.LLD.RateLimiter.models.UserRequest;

public class RateLimiterService {

    private final RateLimiterFactory factory;

    public RateLimiterService(RateLimiterFactory factory){
        this.factory=factory;
    }

    public boolean allowRequests(UserRequest userRequest){
        RateLimiterStrategy strategy = factory.getRateLimiterStrategy(userRequest);
        return strategy.allowRequests(userRequest.getUserId());
    }
}
