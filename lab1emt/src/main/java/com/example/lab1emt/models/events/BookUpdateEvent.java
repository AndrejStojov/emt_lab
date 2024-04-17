package com.example.lab1emt.models.events;

import com.example.lab1emt.models.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
@Getter
public class BookUpdateEvent extends ApplicationEvent {
    private LocalDateTime createTime;
    public BookUpdateEvent(Book book){
        super(book);
        this.createTime=LocalDateTime.now();
    }
    public BookUpdateEvent(Book book, LocalDateTime createTime){
        super(book);
        this.createTime=createTime;
    }
}
