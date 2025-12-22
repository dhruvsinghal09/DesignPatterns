package main.java.LLD.LibraryManagementSystem.services;

import main.java.LLD.LibraryManagementSystem.models.BookIssue;

import java.time.Duration;
import java.time.LocalDateTime;

public class FineService {

    public FineService() {
    }

    public double calculateFine(BookIssue bookIssue) {
        return Duration.between(LocalDateTime.now(), bookIssue.getDueDate()).toMillis() * 10;
    }
}
