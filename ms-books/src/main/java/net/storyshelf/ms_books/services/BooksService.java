package net.storyshelf.ms_books.services;

import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.dtos.FilteredBookDto;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.mappers.BookEntityMapper;
import net.storyshelf.ms_books.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public Iterable<Book> getAllBooks(FilteredBookDto filteredBookDto) {
        // PageRequest request = PageRequest.of(filteredBookDto.getOffset(), filteredBookDto.getLimit())
        PageRequest request = PageRequest.ofSize(filteredBookDto.getLimit())
            .withPage(filteredBookDto.getOffset())
            .withSort(Sort.by("title").descending());
        
        if (!isNullOrEmpty(filteredBookDto.getSearch()) && !isNullOrEmpty(filteredBookDto.getCategory())) {
            return booksRepository.findByTitleAndCategory(filteredBookDto.getSearch(), filteredBookDto.getCategory(), request);
        } 
        
        if (!isNullOrEmpty(filteredBookDto.getSearch())) {
            return booksRepository.findByTitleContaining(filteredBookDto.getSearch(), request);
        }

        if (!isNullOrEmpty(filteredBookDto.getCategory())) {
            return booksRepository.findByCategory(filteredBookDto.getCategory(), request);
        }

        return booksRepository.findAll(request);
    }

    public Optional<Book> getBookById(String id) {
        return booksRepository.findById(id);
    }

    public Book createBook(CreateBookDto bookDto) {
        Book book = BookEntityMapper.from(bookDto);
        return booksRepository.save(book);
    }
}
