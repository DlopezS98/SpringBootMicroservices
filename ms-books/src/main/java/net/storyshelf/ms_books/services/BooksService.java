package net.storyshelf.ms_books.services;

import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Iterable<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return booksRepository.findById(id);
    }

    public Book createBook(CreateBookDto bookDto) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setIsbn(bookDto.getIsbn());
        book.setCategories(bookDto.getCategories());
        book.setDescription(bookDto.getDescription());
        book.setPages(bookDto.getPages());
        book.setCoverUrl(bookDto.getCoverUrl());

        return booksRepository.save(book);
    }
}
