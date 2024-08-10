package net.storyshelf.ms_books.controllers;

import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public Iterable<Book> getBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody CreateBookDto book) {
        return booksService.createBook(book);
    }
}
