package net.storyshelf.ms_books.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateBookDto {
    private String title;
    private String author;
    private String isbn;
    private String description;
    private String publisher;
    private int pages;
    private String coverUrl;
    private List<String> categories;
}
