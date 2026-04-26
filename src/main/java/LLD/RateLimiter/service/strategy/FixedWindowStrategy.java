package main.java.LLD.RateLimiter.service.strategy;

import main.java.LLD.RateLimiter.config.RateLimiterConfig;
import main.java.LLD.RateLimiter.models.UserWindowState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedWindowStrategy implements RateLimiterStrategy{

    private final Map<String, UserWindowState> requestsConsumed;
    private final RateLimiterConfig config;

    public FixedWindowStrategy(RateLimiterConfig config){
        requestsConsumed=new ConcurrentHashMap<>();
        this.config=config;
    }

    @Override
    public boolean allowRequests(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long currWindow = System.currentTimeMillis()/1000/config.getWindowSize();

        requestsConsumed.compute(userId, (id,state)->{
            if(state==null){
                state=new UserWindowState(1,currWindow);
                allowed.set(true);
                return state;
            }
            long lastWin = state.getLastWindow();
            if(lastWin!=currWindow){
                state.setLastWindow(currWindow);
                allowed.set(true);
                state.setCount(1);
                return state;
            }
            if(state.getCount()>=config.getMaxRequests()){
                return state;
            }
            allowed.set(true);
            state.setCount(state.getCount()+1);
            return state;
        });
        return allowed.get();
    }
}
