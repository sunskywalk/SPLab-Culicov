package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uvt.models.Book;
import ro.uvt.requests.NewBookRequest;
import ro.uvt.services.BooksService;
import ro.uvt.subjects.AllBooksSubject;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final AllBooksSubject allBooksSubject;

    // Конструкторная инъекция зависимостей
    @Autowired
    public BooksController(BooksService booksService, AllBooksSubject allBooksSubject) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
    }

    // Получить все книги
    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks(); // Возвращаем список всех книг
    }

    // Получить книгу по ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Book book = booksService.getBookById(id);
        if (book == null) {
            throw new IllegalArgumentException("Книга с ID " + id + " не найдена");
        }
        return book;
    }

    // Создать новую книгу
    @PostMapping("/new")
    public String newBook(@RequestBody NewBookRequest newBookRequest) {
        Book newBook = booksService.createBook(new Book(newBookRequest.getTitle()));
        allBooksSubject.add(newBook); // Уведомляем наблюдателей о новом объекте

        return "Book created successfully with title: " + newBook.getTitle();
    }

    // Обновить книгу
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody NewBookRequest bookRequest) {
        Book updatedBook = booksService.updateBook(id, new Book(bookRequest.getTitle()));
        if (updatedBook == null) {
            throw new IllegalArgumentException("Книга с ID " + id + " не найдена для обновления");
        }
        return updatedBook;
    }

    // Удалить книгу
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        String result = booksService.deleteBook(id);
        return result; // Возвращаем сообщение об удалении
    }
}