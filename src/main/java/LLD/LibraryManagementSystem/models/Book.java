package main.java.LLD.LibraryManagementSystem.models;

import java.util.List;
import java.util.UUID;

public class Book {

    private final String id;
    private final String title;
    private final List<String> authors;
    private final BookCategory category;

    public Book(String title, List<String> authors, BookCategory category) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.authors = authors;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public BookCategory getCategory() {
        return category;
    }
}
