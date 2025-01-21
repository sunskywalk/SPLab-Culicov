package ro.uvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Дополнительные методы поиска, если нужно
}