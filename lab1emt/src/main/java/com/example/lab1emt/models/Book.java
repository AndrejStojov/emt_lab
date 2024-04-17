package com.example.lab1emt.models;

import jakarta.persistence.*;
import lombok.Data;
@Table(name="library_book")
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Category category;

    @ManyToOne
    private Author author;
    private int availableCopies;

    public Book(String name, Category category, Author author, int availableCopies) {

        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }


    public Book() {

    }
}
