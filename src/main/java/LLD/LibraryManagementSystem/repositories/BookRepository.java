package main.java.LLD.LibraryManagementSystem.repositories;

import main.java.LLD.LibraryManagementSystem.models.BookItem;

import java.util.concurrent.ConcurrentHashMap;

public class BookRepository {

    ConcurrentHashMap<String, BookItem> books = new ConcurrentHashMap<>();

    public void addBooks(BookItem bookItem) {
        books.putIfAbsent(bookItem.getId(), bookItem);
    }

    public BookItem getBook(String bookId) {
        if (books.containsKey(bookId)) {
            return books.get(bookId);
        }
        System.out.println("We don't have this book at our library currently.");
        return null;
    }

    public void removeBook(String bookId) {
        books.remove(bookId);
        System.out.println("Book " + bookId + " successfully removed from the library");
    }

    public boolean exists(String id) {
        return books.containsKey(id);
    }
}
