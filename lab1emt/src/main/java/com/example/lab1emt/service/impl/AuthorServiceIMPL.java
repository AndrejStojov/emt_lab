package com.example.lab1emt.service.impl;

import com.example.lab1emt.models.Author;
import com.example.lab1emt.models.exceptions.InvalidAuthorIdException;
import com.example.lab1emt.models.exceptions.InvalidCouthryIdException;
import com.example.lab1emt.repository.AuthorRepository;
import com.example.lab1emt.repository.CountryRepository;
import com.example.lab1emt.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceIMPL implements AuthorService
{
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
    }

    @Override
    public Author create(String name, String surname, Long countryId) {
        Author author=new Author(name,surname,countryRepository.findById(countryId).orElseThrow(InvalidCouthryIdException::new));

        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, String name, String surname, Long countryId) {
        Author author=authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(countryRepository.findById(countryId).orElseThrow(InvalidCouthryIdException::new));

        return authorRepository.save(author);
    }

    @Override
    public Author delete(Long id) {
        Author author=authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        authorRepository.delete(author);
        return author;
    }
}
