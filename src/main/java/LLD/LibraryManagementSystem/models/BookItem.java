package main.java.LLD.LibraryManagementSystem.models;

public class BookItem {

    private final String id;
    private Book book;
    private BookStatus status;
    private Rack rack;

    public BookItem(Book book, Rack rack) {
        this.id = book.getId();
        this.book = book;
        this.rack = rack;
        this.status = BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Rack getRack() {
        return rack;
    }
}
