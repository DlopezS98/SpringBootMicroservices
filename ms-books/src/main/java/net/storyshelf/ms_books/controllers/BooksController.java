package net.storyshelf.ms_books.controllers;

import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.dtos.FilteredBookDto;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public Iterable<Book> getBooks(
        @RequestParam(defaultValue = "") String search, 
        @RequestParam(defaultValue = "") String category, 
        @RequestParam(defaultValue = "0") int offset, 
        @RequestParam(defaultValue = "10") int limit
    ) {
        FilteredBookDto filteredBookDto = new FilteredBookDto();
        filteredBookDto.setSearch(search);
        filteredBookDto.setCategory(category);
        filteredBookDto.setOffset(offset);
        filteredBookDto.setLimit(limit);

        return booksService.getAllBooks(filteredBookDto);
    }

    @PostMapping
    public Book addBook(@RequestBody CreateBookDto book) {
        return booksService.createBook(book);
    }
}
