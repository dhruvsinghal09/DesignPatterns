package main.java.LLD.LibraryManagementSystem.services;

import main.java.LLD.LibraryManagementSystem.models.*;
import main.java.LLD.LibraryManagementSystem.repositories.BookRepository;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryService {

    private final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();

    private BookRepository bookRepository;
    private FineService fineService;

    public LibraryService(BookRepository bookRepository, FineService fineService) {
        this.bookRepository = bookRepository;
        this.fineService = fineService;
    }

    public BookIssue issueBook(Member member, Book issueBook) {
        if (bookRepository.exists(issueBook.getId())) {
            BookItem bookItem = bookRepository.getBook(issueBook.getId());
            Object lock = locks.getOrDefault(bookItem.getId(), new Object());
            synchronized (lock) {
                if (!bookItem.getStatus().equals(BookStatus.AVAILABLE)) {
                    System.out.println("Book not available, already issued by another member");
                    return null;
                } else if (member.getMaxBooksAllowed() == member.getCurrentBooksIssued()) {
                    System.out.println("Dear Member " + member.getName() + ", You already have max books issued.");
                }
                BookIssue bookIssue = new BookIssue(LocalDateTime.now().plusDays(10), member, bookItem);
                bookItem.setStatus(BookStatus.ISSUED);
                member.setCurrentBooksIssued(member.getCurrentBooksIssued() + 1);
                System.out.println("Book successfully issued to respected member Mr. " + member.getName());
                return bookIssue;
            }
        }
        System.out.println("We don't have this book right now in our library");
        return null;
    }

    public double submitBook(BookIssue bookIssue) {
        LocalDateTime dueDate = bookIssue.getDueDate();
        if (dueDate.isBefore(LocalDateTime.now())) {
            double fine = fineService.calculateFine(bookIssue);
            System.out.println("Your due date was " + dueDate);
            System.out.println("Please pay fine of " + fine);
            return fine;
        }
        BookItem bookItem = bookIssue.getBookItem();
        bookItem.setStatus(BookStatus.AVAILABLE);
        Member member = bookIssue.getMember();
        member.setCurrentBooksIssued(member.getCurrentBooksIssued() - 1);
        System.out.println("Book Successfully Submitted Back");
        return 0;
    }
}
