package main.java.LLD.LibraryManagementSystem.models;

import java.util.UUID;

public class Member extends User {

    private final int maxBooksAllowed;
    private int currentBooksIssued;

    public Member(String name) {
        super(UUID.randomUUID().toString(), name);
        this.maxBooksAllowed = 5;
    }

    public int getCurrentBooksIssued() {
        return currentBooksIssued;
    }

    public void setCurrentBooksIssued(int currentBooksIssued) {
        this.currentBooksIssued = currentBooksIssued;
    }

    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }
}
