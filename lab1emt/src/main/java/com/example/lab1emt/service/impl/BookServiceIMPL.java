package com.example.lab1emt.service.impl;

import com.example.lab1emt.models.Book;
import com.example.lab1emt.models.Category;
import com.example.lab1emt.models.events.BookCreatedEvent;
import com.example.lab1emt.models.events.BookDeleteEvent;
import com.example.lab1emt.models.events.BookUpdateEvent;
import com.example.lab1emt.models.exceptions.InvalidAuthorIdException;
import com.example.lab1emt.models.exceptions.InvalidBookIdException;
import com.example.lab1emt.repository.AuthorRepository;
import com.example.lab1emt.repository.BookRepository;
import com.example.lab1emt.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceIMPL implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> filter(String name) {
        return bookRepository.findAllByNameContaining(name);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book create(String name, Category category, Long author, int availableCopies) {
        Book book = new Book(name,category,authorRepository.findById(author).orElseThrow(InvalidAuthorIdException::new),availableCopies);
        applicationEventPublisher.publishEvent(new BookCreatedEvent(book));
        return bookRepository.save(book);
    }




    @Override
    public Book update(Long id, String name, Category category, Long author, int availableCopies) {
        Book book=bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(authorRepository.findById(author).orElseThrow(InvalidAuthorIdException::new));
        book.setAvailableCopies(availableCopies);
        applicationEventPublisher.publishEvent(new BookUpdateEvent(book));
        return bookRepository.save(book);
    }



    @Override
    public Book delete(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        bookRepository.delete(book);
        applicationEventPublisher.publishEvent(new BookDeleteEvent(book));
        return book;
    }

    @Override
    public Book rent(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        if(book.getAvailableCopies()>0){
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }

        return bookRepository.save(book);
    }

    @Override
    public void refreshMaterializedView() {

    }
}
