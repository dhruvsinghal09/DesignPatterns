package main.java.DesignPatterns.BehavioralPatterns.IteratorPattern;

import java.util.*;
import java.util.Iterator;

public class BookCollectionV2 implements Iterable<Book>{

    private Set<Book> books;

    public BookCollectionV2(){
        books = new TreeSet<>();
    }

    public void addBooks(Book book){
        books.add(book);
    }

    /*
    Java gives us Iterable interface which gives us iterator method to override.
    We won't have to create it as our own as we did in BookCollectionV1
     */
    @Override
    public Iterator<Book> iterator() {
        /*
        All the collections itself have iterator inbuilt.
        We don't have to create our own private iterator as we did in BookCollectionV1
         */
        return books.iterator();
    }
}
