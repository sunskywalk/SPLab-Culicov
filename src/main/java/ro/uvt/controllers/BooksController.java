package ro.uvt.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping
    public String getAllBooks() {
        return "Returning all books (dummy response)";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable String id) {
        return "Returning details for book with id: " + id;
    }

    @PostMapping
    public String createBook() {
        return "Book created (dummy response)";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable String id) {
        return "Book with id " + id + " updated (dummy response)";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        return "Book with id " + id + " deleted (dummy response)";
    }
}