package main.java.DesignPatterns.BehavioralPatterns.IteratorPattern;
/*
There already exits Iterator Interface in java utils package
but defining it here just for clarity of thought
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
