package net.storyshelf.ms_writer.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Book extends AuditableEntity {
    public String title;
    public String author;
    public String isbn;
    public int pages;
    public String coverUrl;
    public LocalDateTime publishDate;

    public Book() {}

    public Book(String id, String title, String author, String isbn, int pages, String coverUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.coverUrl = coverUrl;
    }

    public static List<Book> getBooks() {
        return List.of(
                new Book("1", "Book 1", "Danny Lopez", "828282", 10, ""),
                new Book("2", "Book 2", "Danny Lopez", "44344", 77, ""),
                new Book("3", "Book 3", "Danny Lopez", "92183", 95, "")
        );
    }
}
