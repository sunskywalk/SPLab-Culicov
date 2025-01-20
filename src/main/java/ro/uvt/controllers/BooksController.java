package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uvt.commands.Command;
import ro.uvt.commands.GetAllBooksCommand;
import ro.uvt.executors.CommandExecutor;
import ro.uvt.services.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor commandExecutor;

    @Autowired
    public BooksController(BooksService booksService, CommandExecutor commandExecutor) {
        this.booksService = booksService;
        this.commandExecutor = commandExecutor;
    }

    @GetMapping
    public String getAllBooks() {
        Command command = new GetAllBooksCommand(booksService);
        return commandExecutor.executeSync(command);
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable String id) {
        return booksService.getBookById(id);
    }

    @PostMapping
    public String createBook(@RequestParam String id, @RequestParam String details) {
        return booksService.createBook(id, details);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable String id, @RequestParam String details) {
        return booksService.updateBook(id, details);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        return booksService.deleteBook(id);
    }
}