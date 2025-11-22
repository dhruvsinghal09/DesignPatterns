package main.java.BehavioralPatterns.IteratorPattern;

public class Main {

    public static void main(String[] args){
        Book book = new Book("B1");
        Book book1 = new Book("B2");
        Book book2 = new Book("B3");
        /*
        BookCollectionV2 is implemented using custom iterator
         */
        BookCollectionV1 bookCollectionV1 = new BookCollectionV1();
        bookCollectionV1.addBooks(book);
        bookCollectionV1.addBooks(book1);
        bookCollectionV1.addBooks(book2);
        Iterator iterator = bookCollectionV1.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*
        BookCollectionV2 is implemented using java utils iterator
         */
        BookCollectionV2 bookCollectionV2 = new BookCollectionV2();
        bookCollectionV2.addBooks(book);
        bookCollectionV2.addBooks(book1);
        bookCollectionV2.addBooks(book2);
        java.util.Iterator iterator1 = bookCollectionV2.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
