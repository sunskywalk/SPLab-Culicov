package ro.uvt.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BooksService {
    private final Map<String, String> books = new HashMap<>();

    public List<String> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public String getBookById(String id) {
        return books.getOrDefault(id, "Book not found");
    }

    public String createBook(String id, String details) {
        books.put(id, details);
        return "Book created with id: " + id;
    }

    public String updateBook(String id, String details) {
        books.put(id, details);
        return "Book updated with id: " + id;
    }

    public String deleteBook(String id) {
        books.remove(id);
        return "Book deleted with id: " + id;
    }
}