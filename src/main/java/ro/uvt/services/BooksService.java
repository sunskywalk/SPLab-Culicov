package ro.uvt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.models.Author;
import ro.uvt.models.Book;
import ro.uvt.repositories.BookRepository;
import ro.uvt.requests.NewBookRequest;

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

    // Создать книгу (через NewBookRequest)
    public Book createBook(NewBookRequest newBookRequest) {
        Author author = new Author(newBookRequest.getAuthor(), "");
        Book book = new Book(newBookRequest.getTitle());
        // Здесь можно добавить дополнительные данные, например авторов, если нужно
        return booksRepository.save(book);
    }

    // Создать книгу (через объект Book)
    public Book createBook(Book book) {
        return booksRepository.save(book);
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
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return "Book deleted with id: " + id;
        } else {
            return "Book with id " + id + " not found.";
        }
    }
}