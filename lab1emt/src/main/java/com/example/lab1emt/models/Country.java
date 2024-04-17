package com.example.lab1emt.models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="author_country")
@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;

    public Country(String name, String continent) {

        this.name = name;
        this.continent = continent;
    }

    public Country() {

    }
}
