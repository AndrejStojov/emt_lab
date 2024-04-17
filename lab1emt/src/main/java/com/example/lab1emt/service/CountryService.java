package com.example.lab1emt.service;

import com.example.lab1emt.models.Book;
import com.example.lab1emt.models.Country;
import jdk.jfr.Category;

import java.util.List;

public interface CountryService {
    List<Country> listAll();
    Country findById(Long id);
    Country create(String name, String continent);
    Country update(Long id, String name, String continent);
    Country delete(Long id);
}
