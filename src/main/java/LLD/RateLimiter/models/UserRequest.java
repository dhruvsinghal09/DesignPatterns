package main.java.LLD.RateLimiter.models;

public class UserRequest {

    private final String userId;
    private Tier tier;

    public UserRequest(String userId,Tier tier){
        this.userId=userId;
        this.tier=tier;
    }

    public String getUserId() {
        return userId;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
}
