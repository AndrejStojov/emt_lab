package com.example.lab1emt.web;

import com.example.lab1emt.models.Author;
import com.example.lab1emt.models.dto.AuthorDTO;
import com.example.lab1emt.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> listAll(){
        return authorService.listAll();
    }
    @GetMapping("/{id}")
    public Author findById(
            @PathVariable Long id
    ){
     return authorService.findById(id);
    }

    @PostMapping("/add")
    public void create(
            @RequestBody AuthorDTO authorDTO
    ){
           authorService.create(authorDTO.getName(),authorDTO.getSurname(),authorDTO.getCountryId());
    }

    @PostMapping("/edit/{id}")
    public void update(@PathVariable Long id,@RequestBody AuthorDTO authorDTO){
        authorService.update(id,authorDTO.getName(),authorDTO.getSurname(),authorDTO.getCountryId());
    }

    @PostMapping("/delete/{id}")
    public void delete(
            @PathVariable Long id
    ){
        authorService.delete(id);
    }
}
