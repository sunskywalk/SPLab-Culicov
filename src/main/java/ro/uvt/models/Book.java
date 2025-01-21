package ro.uvt.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "books") // Название таблицы для хранения объектов Book
public class Book extends BaseElement {

    // Геттеры и сеттеры
    @Column(nullable = false) // Поле title обязательно
    private String title;

    // Список контента (разделы, параграфы и т.д.)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_id") // Внешний ключ для связи с книгой
    private List<BaseElement> content = new ArrayList<>();

    // Список авторов
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private List<Author> authors = new ArrayList<>();

    // Пустой конструктор для JPA
    public Book() {}

    // Конструктор для создания книги с заголовком
    public Book(String title) {
        this.title = title;
    }

    // Методы для добавления/удаления контента
    public void addContent(BaseElement element) {
        content.add(element);
    }

    public void removeContent(BaseElement element) {
        content.remove(element);
    }

    // Методы для добавления авторов
    public void addAuthor(Author author) {
        authors.add(author);
        if (!author.getBooks().contains(this)) {
            author.getBooks().add(this);
        }
    }

    // Метод для вывода информации о книге
    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("Content:");
        for (BaseElement element : content) {
            element.print();
        }
    }

    // Метод для удобного вывода информации о книге в виде строки
    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", content=" + content +
                '}';
    }
}