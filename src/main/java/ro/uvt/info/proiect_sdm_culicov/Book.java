package ro.uvt.info.proiect_sdm_culicov;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private String title;
    private List<Element> content = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        for (Element element : content) {
            element.print();
        }
    }
}