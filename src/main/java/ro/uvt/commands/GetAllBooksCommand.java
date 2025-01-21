package ro.uvt.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.uvt.models.Book;
import ro.uvt.services.BooksService;

import java.util.stream.Collectors;

@Component
public class GetAllBooksCommand {
    private final BooksService booksService;

    @Autowired
    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public String execute() {
        return booksService.getAllBooks().stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
    }
}