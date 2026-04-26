package main.java.LLD.RateLimiter.service.strategy;

import main.java.LLD.RateLimiter.config.RateLimiterConfig;
import main.java.LLD.RateLimiter.models.UserWindowState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TokenBucketStrategy implements RateLimiterStrategy{

    private final Map<String, UserWindowState> userTokens;
    private final RateLimiterConfig config;

    public TokenBucketStrategy(RateLimiterConfig config){
        userTokens=new ConcurrentHashMap<>();
        this.config=config;
    }
    @Override
    public boolean allowRequests(String userId) {
        long now = System.currentTimeMillis();
        AtomicBoolean allowed = new AtomicBoolean(false);
        userTokens.compute(userId,(id,state)->{
            if(state==null){
                allowed.set(true);
                return new UserWindowState(config.getMaxRequests()-1,now);
            }
            int currBucket = refillTokens(state,now);
            if(currBucket>0){
                allowed.set(true);
                state.setCount(currBucket-1);
                return state;
            }
            return state;
        });
        return allowed.get();
    }

    private int refillTokens(UserWindowState state,long now){
        long lastRefill = state.getLastWindow();
        double tokenPerMs = (double) config.getMaxRequests()/(config.getWindowSize()* 1000);
        int noOfTokenToRefill = (int) ((now-lastRefill)*tokenPerMs);
        int currTokens = state.getCount();
        currTokens = Math.min(noOfTokenToRefill+currTokens,config.getMaxRequests());
        state.setCount(currTokens);
        state.setLastWindow(now);
        return currTokens;
    }
}
