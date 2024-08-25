package net.storyshelf.ms_books.controllers;

import net.storyshelf.ms_books.dtos.BookDto;
import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.dtos.FilteredBookDto;
import net.storyshelf.ms_books.dtos.QueryResult;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.services.BooksService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @GetMapping
    public QueryResult<BookDto> getBooks(
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

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id) {
        BookDto bookDto = booksService.getBookById(id).orElse(null);
        if (bookDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookDto);
    }
}
