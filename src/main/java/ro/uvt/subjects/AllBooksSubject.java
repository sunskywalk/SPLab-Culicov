package ro.uvt.subjects;

import org.springframework.stereotype.Component;
import ro.uvt.models.Book;
import ro.uvt.observers.Observer;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }


    public void add(Book book) {
        notifyAllObservers(book);
    }

    private void notifyAllObservers(Book book) {
        for (Observer observer : observers) {
            try {
                observer.update(book);
            } catch (Exception e) {
                System.err.println("Error notifying observer: " + e.getMessage());
            }
        }
    }
}