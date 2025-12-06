package main.java.DesignPatterns.BehavioralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class BookCollectionV1 {

    private List<Book> books;

    public BookCollectionV1(){
        books = new ArrayList<>();
    }

    public void addBooks(Book book){
        books.add(book);
    }

    public Iterator createIterator(){
        return new BookIterator(books);
    }

    private class BookIterator implements Iterator<Book>{
        private List<Book> bks;
        private int position=0;

        public BookIterator(List<Book> books){
            this.bks=new ArrayList<>();
            this.bks=books;
        }

        @Override
        public boolean hasNext() {
            return position < bks.size();
        }

        @Override
        public Book next() {
            return bks.get(position++);
        }
    }
}
