package main.java.LLD.RateLimiter.service.factory;

import main.java.LLD.RateLimiter.config.RateLimiterConfig;
import main.java.LLD.RateLimiter.models.Tier;
import main.java.LLD.RateLimiter.models.UserRequest;
import main.java.LLD.RateLimiter.service.strategy.FixedWindowStrategy;
import main.java.LLD.RateLimiter.service.strategy.RateLimiterStrategy;
import main.java.LLD.RateLimiter.service.strategy.SlidingWindowStrategy;
import main.java.LLD.RateLimiter.service.strategy.TokenBucketStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterFactory {

    private final Map<String, RateLimiterStrategy> strategy;
    private final Map<String, RateLimiterConfig> configMap;

    public RateLimiterFactory(){
        strategy=new ConcurrentHashMap<>();
        configMap=new ConcurrentHashMap<>();
    }

    public RateLimiterStrategy getRateLimiterStrategy(UserRequest userRequest){
        return switch (userRequest.getTier()){
            case FREE -> strategy.computeIfAbsent(Tier.FREE.name(), s->new FixedWindowStrategy(configMap.computeIfAbsent(Tier.FREE.name(), c->new RateLimiterConfig(5,180))));
            case PREMIUM -> strategy.computeIfAbsent(Tier.PREMIUM.name(),s->new TokenBucketStrategy(configMap.computeIfAbsent(Tier.PREMIUM.name(), c->new RateLimiterConfig(100,180))));
            default -> strategy.computeIfAbsent("default",s->new SlidingWindowStrategy(configMap.computeIfAbsent("default", c->new RateLimiterConfig(5,180))));
        };
    }
}
