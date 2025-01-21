package ro.uvt.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "images")
public class Image extends BaseElement {

    @Column(nullable = false)
    private String url;

    public Image() {
        // Пустой конструктор для JPA
    }

    public Image(String url) {
        this.url = url;
    }

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + getId() +
                ", url='" + url + '\'' +
                '}';
    }
}