package main.java.LLD.LibraryManagementSystem.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Rack {

    private int rackNo;
    private String location;
    AtomicInteger rack = new AtomicInteger();

    public Rack(String location) {
        this.rackNo = rack.addAndGet(1);
        this.location = location;
    }

    public int getRackNo() {
        return rackNo;
    }

    public String getLocation() {
        return location;
    }
}
