package ro.uvt.models;

import jakarta.persistence.*;
import ro.uvt.strategies.AlignStrategy;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "paragraphs")
public class Paragraph extends BaseElement {
    @Column(name = "text", nullable = false)
    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph() {
        // Конструктор по умолчанию, необходимый для JPA
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(text);
        } else {
            System.out.println(String.format("Paragraph: %s", text));
        }
    }
}