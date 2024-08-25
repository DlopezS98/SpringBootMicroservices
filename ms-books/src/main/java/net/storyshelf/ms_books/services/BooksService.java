package net.storyshelf.ms_books.services;

import net.storyshelf.ms_books.dtos.BookDto;
import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.dtos.FilteredBookDto;
import net.storyshelf.ms_books.dtos.QueryResult;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.mappers.BookEntityMapper;
import net.storyshelf.ms_books.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public QueryResult<BookDto> getAllBooks(FilteredBookDto filteredBookDto) {
        // PageRequest request = PageRequest.of(filteredBookDto.getOffset(), filteredBookDto.getLimit())
        PageRequest request = PageRequest.ofSize(filteredBookDto.getLimit())
            .withPage(filteredBookDto.getOffset())
            .withSort(Sort.by("title").descending());
        
        if (!isNullOrEmpty(filteredBookDto.getSearch()) && !isNullOrEmpty(filteredBookDto.getCategory())) {
            Page<Book> page = booksRepository.findByTitleAndCategory(filteredBookDto.getSearch(), filteredBookDto.getCategory(), request);
            List<BookDto> dtos = page.stream().map(BookEntityMapper::toDto).toList();
            return new QueryResult<>(page.getTotalElements(), dtos);
        } 
        
        if (!isNullOrEmpty(filteredBookDto.getSearch())) {
            Page<Book> books = booksRepository.findByTitleContaining(filteredBookDto.getSearch(), request);
            List<BookDto> dtos = books.stream().map(BookEntityMapper::toDto).toList();
            return new QueryResult<>(books.getTotalElements(), dtos);
        }

        if (!isNullOrEmpty(filteredBookDto.getCategory())) {
            Page<Book> books = booksRepository.findByCategory(filteredBookDto.getCategory(), request);
            List<BookDto> dtos = books.stream().map(BookEntityMapper::toDto).toList();
            return new QueryResult<>(books.getTotalElements(), dtos);
        }

        Page<Book> books = booksRepository.findAll(request);
        List<BookDto> dtos = books.stream().map(BookEntityMapper::toDto).toList();
        return new QueryResult<>(books.getTotalElements(), dtos);
    }

    public Optional<BookDto> getBookById(String id) {
        BookDto bookDto = booksRepository.findById(id).map(BookEntityMapper::toDto).orElse(null);
        return Optional.ofNullable(bookDto);
    }

    public Book createBook(CreateBookDto bookDto) {
        Book book = BookEntityMapper.from(bookDto);
        return booksRepository.save(book);
    }
}
