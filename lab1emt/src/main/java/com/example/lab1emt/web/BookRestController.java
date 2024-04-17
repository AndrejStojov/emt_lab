package com.example.lab1emt.web;

import com.example.lab1emt.models.Book;
import com.example.lab1emt.models.Category;
import com.example.lab1emt.models.dto.BookDTO;
import com.example.lab1emt.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> listAll(
            @RequestParam(required = false) String name
    ){
        if(name!=null){
            return bookService.filter(name);
        }
        return bookService.listAll();
    }

    @GetMapping("/categories")
    public List<Category> listAllCategories(

    ){
        return Arrays.stream(Category.values()).toList();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody BookDTO bookDTO){
        bookService.create(bookDTO.getName(),bookDTO.getCategory(),bookDTO.getAuthorId(),bookDTO.getAvailableCopies());
    }

    @PostMapping("/edit/{id}")
    public void update(@PathVariable Long id,@RequestBody BookDTO bookDTO){
        bookService.update(id,bookDTO.getName(),bookDTO.getCategory(),bookDTO.getAuthorId(),bookDTO.getAvailableCopies());
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }

    @PostMapping("/rent/{id}")
    public Book rentBook(@PathVariable Long id){
        return bookService.rent(id);
    }

}
