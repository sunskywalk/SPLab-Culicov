package ro.uvt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
import ro.uvt.repositories.BookRepository;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BookRepository booksRepository;

    // Получить все книги
    public List<Book> getAllBooks() {
        return booksRepository.findAll(); // Используем метод из JpaRepository
    }

    // Получить книгу по ID
    public Book getBookById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    // Создать книгу
    public Book createBook(Book book) {
        return booksRepository.save(book); // Сохраняем книгу в базу данных
    }

    // Обновить книгу
    public Book updateBook(Long id, Book bookDetails) {
        Book book = booksRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setContent(bookDetails.getContent());
            book.setAuthors(bookDetails.getAuthors());
            return booksRepository.save(book);
        }
        return null; // Или можно вернуть исключение
    }

    // Удалить книгу
    public String deleteBook(Long id) {
        booksRepository.deleteById(id);
        return "Book deleted with id: " + id;
    }
}