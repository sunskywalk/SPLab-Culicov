package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class GetAllBooksCommand implements Command {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public String execute() {
        return String.join(", ", booksService.getAllBooks());
    }
}