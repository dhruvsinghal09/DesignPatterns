package main.java.LLD.RateLimiter.service.strategy;

import main.java.LLD.RateLimiter.config.RateLimiterConfig;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class SlidingWindowStrategy implements RateLimiterStrategy{

    private Map<String, Deque<Long>> requests;
    private final RateLimiterConfig config;

    public SlidingWindowStrategy(RateLimiterConfig config){
        requests=new ConcurrentHashMap<>();
        this.config=config;
    }

    @Override
    public boolean allowRequests(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long now = System.currentTimeMillis();
        requests.compute(userId,(id,q)->{
            if(q==null){
                q=new ConcurrentLinkedDeque<>();
                q.offerFirst(now);
                allowed.set(true);
                return q;
            }

            while(!q.isEmpty() && (now-q.peekLast())>=(config.getWindowSize()* 1000L)){
                q.pollLast();
            }
            if(q.size()>=config.getMaxRequests()){
                return q;
            }
            allowed.set(true);
            q.offerFirst(now);
            return q;
        });
        return allowed.get();
    }
}
