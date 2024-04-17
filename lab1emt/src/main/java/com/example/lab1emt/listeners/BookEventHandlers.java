package com.example.lab1emt.listeners;

import com.example.lab1emt.models.events.BookCreatedEvent;
import com.example.lab1emt.models.events.BookDeleteEvent;
import com.example.lab1emt.models.events.BookUpdateEvent;
import com.example.lab1emt.service.BookService;
import com.example.lab1emt.service.CountryService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {

    private final BookService bookService;


    public BookEventHandlers(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onBookCreate(BookCreatedEvent event){
        System.out.println(event);
    }

    @EventListener
    public void onBookDelete(BookDeleteEvent event){
        System.out.println(event);
    }

    @EventListener
    public void onBookUpdate(BookUpdateEvent event){
        System.out.println(event);
    }
}
