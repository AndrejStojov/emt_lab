package com.example.lab1emt.service;




import com.example.lab1emt.models.Book;
import com.example.lab1emt.models.Category;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> filter(String name);
    Book findById(Long id);
    Book create(String name, Category category, Long author, int availableCopies);
    Book update(Long id, String name, Category category, Long author, int availableCopies);
    Book delete(Long id);
    Book rent(Long id);

    void refreshMaterializedView();
}
