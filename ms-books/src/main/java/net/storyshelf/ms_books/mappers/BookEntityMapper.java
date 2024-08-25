package net.storyshelf.ms_books.mappers;

import net.storyshelf.ms_books.dtos.BookDto;
import net.storyshelf.ms_books.dtos.BookIndustryIdentifierDto;
import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.dtos.ImageLinksDto;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.entities.BookIndustryIdentifier;

import java.util.List;
import java.util.UUID;

public class BookEntityMapper {
    public static Book from(CreateBookDto bookDto) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setKind(bookDto.getKind());
        book.setEtag(bookDto.getEtag());
        book.setSelfLink(bookDto.getSelfLink());
        book.setTitle(bookDto.getTitle());
        book.setSubtitle(bookDto.getSubtitle());
        book.setAuthors(bookDto.getAuthors());
        book.setPublisher(bookDto.getPublisher());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setDescription(bookDto.getDescription());
        List<BookIndustryIdentifier> identifiers = bookDto.getIndustryIdentifiers()
            .stream()
            .map(BookEntityMapper::from)
            .toList();
        book.setIndustryIdentifiers(identifiers);
        book.setPages(bookDto.getPageCount());
        book.setCategories(bookDto.getCategories());
        book.setLanguage(bookDto.getLanguage());
        book.setPreviewLink(bookDto.getPreviewLink());
        book.setCountry(bookDto.getCountry());
        book.setViewability(bookDto.getViewability());
        book.setEpubAvailable(bookDto.isEpubAvailable());

        ImageLinksDto links = bookDto.getImageLinks();
        book.setSmallThumbnail(links.getSmallThumbnail());
        book.setThumbnail(links.getThumbnail());
        book.setSmall(links.getSmall());
        book.setMedium(links.getMedium());
        book.setLarge(links.getLarge());
        book.setExtraLarge(links.getExtraLarge());

        return book;
    }

    private static BookIndustryIdentifier from(BookIndustryIdentifierDto bookIndustryIdentifierDto) {
        BookIndustryIdentifier bookIndustryIdentifier = new BookIndustryIdentifier(
            bookIndustryIdentifierDto.getType(), 
            bookIndustryIdentifierDto.getIdentifier()
        );
        return bookIndustryIdentifier;
    }

    public static BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setKind(book.getKind());
        bookDto.setEtag(book.getEtag());
        bookDto.setSelfLink(book.getSelfLink());
        bookDto.setTitle(book.getTitle());
        bookDto.setSubtitle(book.getSubtitle());
        bookDto.setAuthors(book.getAuthors());
        bookDto.setPublisher(book.getPublisher());
        bookDto.setPublishedDate(book.getPublishedDate());
        bookDto.setDescription(book.getDescription());
        List<BookIndustryIdentifierDto> identifiers = book.getIndustryIdentifiers()
            .stream()
            .map(BookEntityMapper::toDto)
            .toList();
        bookDto.setIndustryIdentifiers(identifiers);
        bookDto.setPageCount(book.getPages());
        bookDto.setCategories(book.getCategories());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setPreviewLink(book.getPreviewLink());
        bookDto.setCountry(book.getCountry());
        bookDto.setViewability(book.getViewability());
        bookDto.setEpubAvailable(book.isEpubAvailable());

        ImageLinksDto links = new ImageLinksDto();
        links.setSmallThumbnail(book.getSmallThumbnail());
        links.setThumbnail(book.getThumbnail());
        links.setSmall(book.getSmall());
        links.setMedium(book.getMedium());
        links.setLarge(book.getLarge());
        links.setExtraLarge(book.getExtraLarge());
        bookDto.setImageLinks(links);

        return bookDto;
    }

    private static BookIndustryIdentifierDto toDto(BookIndustryIdentifier bookIndustryIdentifier) {
        BookIndustryIdentifierDto bookIndustryIdentifierDto = new BookIndustryIdentifierDto(
            bookIndustryIdentifier.getType(), 
            bookIndustryIdentifier.getIdentifier()
        );
        return bookIndustryIdentifierDto;
    }
}
