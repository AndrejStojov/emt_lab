package com.example.lab1emt.service;

import com.example.lab1emt.models.Author;
import jdk.jfr.Category;

import java.util.List;

public interface AuthorService {
    List<Author> listAll();
    Author findById(Long id);
    Author create(String name, String surname, Long countryId);
    Author update(Long id, String name, String surname, Long countryId);
    Author delete(Long id);

}
