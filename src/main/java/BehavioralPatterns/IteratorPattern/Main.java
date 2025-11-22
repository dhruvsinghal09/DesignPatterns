package main.java.BehavioralPatterns.IteratorPattern;

public class Main {

    public static void main(String[] args){
        Book book = new Book("B1");
        Book book1 = new Book("B2");
        Book book2 = new Book("B3");
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBooks(book);
        bookCollection.addBooks(book1);
        bookCollection.addBooks(book2);
        Iterator iterator = bookCollection.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
