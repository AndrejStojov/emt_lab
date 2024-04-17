package com.example.lab1emt.models.dto;

import com.example.lab1emt.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String name;
    private Category category;
    private long authorId;
    private int availableCopies;
}
