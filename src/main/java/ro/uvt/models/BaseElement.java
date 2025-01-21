package ro.uvt.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Используем наследование с объединением таблиц
@Table(name = "elements") // Общая таблица для всех наследников
public abstract class BaseElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автогенерация ID
    private Long id;

    // Геттер для ID
    public Long getId() {
        return id;
    }

    // Сеттер для ID
    public void setId(Long id) {
        this.id = id;
    }

    // Абстрактный метод для реализации в подклассах
    public abstract void print();
}