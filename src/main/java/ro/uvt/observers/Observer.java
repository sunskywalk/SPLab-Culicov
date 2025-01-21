package ro.uvt.observers;

import ro.uvt.models.Book;

public interface Observer {
    default void update(Book book) {
        System.out.println("Observer notified: New book added - " + book.getTitle());
    }
}