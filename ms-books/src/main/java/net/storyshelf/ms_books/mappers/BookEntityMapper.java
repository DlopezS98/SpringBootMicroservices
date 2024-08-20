package net.storyshelf.ms_books.mappers;

import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.entities.Book;

import java.util.UUID;

public class BookEntityMapper {
    public static Book from(CreateBookDto bookDto) {
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

        return book;
    }
}
