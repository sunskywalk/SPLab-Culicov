package ro.uvt.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section extends BaseElement {

    @Column(nullable = false)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "section_id")
    private List<BaseElement> elements = new ArrayList<>();

    public Section() {
        // Пустой конструктор для JPA
    }

    public Section(String title) {
        this.title = title;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BaseElement> getElements() {
        return elements;
    }

    public void setElements(List<BaseElement> elements) {
        this.elements = elements;
    }

    public void add(BaseElement element) {
        elements.add(element);
    }

    public void remove(BaseElement element) {
        elements.remove(element);
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (BaseElement element : elements) {
            element.print();
        }
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", elements=" + elements +
                '}';
    }
}