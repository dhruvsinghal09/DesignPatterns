package main.java.LLD.LibraryManagementSystem.models;

import main.java.LLD.LibraryManagementSystem.repositories.BookRepository;

import java.util.UUID;

public class Librarian extends User{

    private BookRepository bookRepository;

    public Librarian(String name,BookRepository bookRepository) {
        super(UUID.randomUUID().toString(), name);
        this.bookRepository=bookRepository;
    }

    public void addBooks(Book book,String location){
        BookItem bookItem = new BookItem(book,new Rack(location));
        bookRepository.addBooks(bookItem);
    }

    public void removeBook(BookItem book){
        bookRepository.removeBook(book.getId());
    }

}
