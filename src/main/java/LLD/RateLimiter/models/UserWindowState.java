package main.java.LLD.RateLimiter.models;

public class UserWindowState {
    private int count;
    private long lastWindow;

    public UserWindowState(int count,long lastWindow){
        this.count=count;
        this.lastWindow=lastWindow;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getLastWindow() {
        return lastWindow;
    }

    public void setLastWindow(long lastWindow) {
        this.lastWindow = lastWindow;
    }
}
