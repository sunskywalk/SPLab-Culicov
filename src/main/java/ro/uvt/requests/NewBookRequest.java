package ro.uvt.requests;

public class NewBookRequest {
    private String title;  // Название книги
    private String author; // Имя автора

    // Конструктор по умолчанию (нужен для сериализации)
    public NewBookRequest() {}

    // Полный конструктор для удобства создания объекта
    public NewBookRequest(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}