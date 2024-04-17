package com.example.lab1emt.models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="library_author")
@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;


    public Author(String name, String surname, Country country) {

        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {

    }
}
