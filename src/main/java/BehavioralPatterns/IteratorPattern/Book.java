package main.java.BehavioralPatterns.IteratorPattern;

public class Book implements Comparable<Book>{

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    /*
    We have to override compare method also as
    now we are using TreeSet in bookCollectionV2 which keeps sorted elements
     */
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);  // or any field you want
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
