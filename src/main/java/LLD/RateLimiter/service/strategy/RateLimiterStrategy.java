package main.java.LLD.RateLimiter.service.strategy;

public interface RateLimiterStrategy {

    public boolean allowRequests(String userId);
}
