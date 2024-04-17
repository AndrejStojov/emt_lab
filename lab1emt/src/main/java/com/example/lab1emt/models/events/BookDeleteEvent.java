package com.example.lab1emt.models.events;

import com.example.lab1emt.models.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class BookDeleteEvent extends ApplicationEvent {
    private LocalDateTime createTime;
    public BookDeleteEvent(Book book){
        super(book);
        this.createTime=LocalDateTime.now();
    }
    public BookDeleteEvent(Book book, LocalDateTime createTime){
        super(book);
        this.createTime=createTime;
    }
}
