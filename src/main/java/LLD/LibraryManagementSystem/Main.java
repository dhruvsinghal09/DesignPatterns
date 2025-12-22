package main.java.LLD.LibraryManagementSystem;

import main.java.LLD.LibraryManagementSystem.models.*;
import main.java.LLD.LibraryManagementSystem.repositories.BookRepository;
import main.java.LLD.LibraryManagementSystem.services.FineService;
import main.java.LLD.LibraryManagementSystem.services.LibraryService;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Created few books
        Book book1 = new Book("SystemDesign", List.of("Dhruv"), BookCategory.ACTION);
        Book book2 = new Book("DSA", List.of("Dhruv"), BookCategory.THRILLER);

        // Created a book repository
        BookRepository bookRepository = new BookRepository();

        // Created a librarian to manage books
        Librarian librarian = new Librarian("Ramu", bookRepository);

        //Librarian added the books to the repository
        librarian.addBooks(book1, "Right Wing");
        librarian.addBooks(book2, "Left Wing");

        //Created a member
        Member member = new Member("Singhal");

        //LibraryService which will be issuing the books to the members
        LibraryService libraryService = new LibraryService(bookRepository, new FineService());

        //Book Issued
        BookIssue bookIssue = libraryService.issueBook(member, book1);

        System.out.println("Book issued with id " + bookIssue.getIssueId());
        System.out.println("No. of books issued to Mr. " + member.getName() + " is: " + member.getCurrentBooksIssued());

        Thread.sleep(1000);


        //Submit the book back
        libraryService.submitBook(bookIssue);

        System.out.println("No. of books issued to Mr. " + member.getName() + " is: " + member.getCurrentBooksIssued());


    }
}
