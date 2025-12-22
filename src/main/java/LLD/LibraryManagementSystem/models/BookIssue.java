package main.java.LLD.LibraryManagementSystem.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookIssue {

    private final String issueId;
    private final LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private final Member member;
    private BookItem bookItem;

    public BookIssue(LocalDateTime dueDate, Member member, BookItem bookItem) {
        this.dueDate = dueDate;
        this.member = member;
        this.issueDate = LocalDateTime.now();
        this.issueId = UUID.randomUUID().toString();
        this.bookItem = bookItem;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public String getIssueId() {
        return issueId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Member getMember() {
        return member;
    }
}
