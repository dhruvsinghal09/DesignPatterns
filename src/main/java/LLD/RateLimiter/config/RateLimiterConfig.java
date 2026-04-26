package main.java.LLD.RateLimiter.config;

public class RateLimiterConfig {

    private int maxRequests;
    private long windowSize;

    public RateLimiterConfig(int maxRequests,long windowSize){
        this.maxRequests=maxRequests;
        this.windowSize=windowSize;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public long getWindowSize() {
        return windowSize;
    }
}
