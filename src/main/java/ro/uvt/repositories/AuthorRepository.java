package ro.uvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Дополнительные методы поиска, если нужно
}