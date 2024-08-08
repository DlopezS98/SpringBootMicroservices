package net.storyshelf.ms_books.entities;

import java.time.LocalDateTime;

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
}
