package net.storyshelf.ms_books.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookDto {
    private String id;
    private String kind;
    private String etag;
    private String selfLink;
    private String title;
    private String subtitle;
    private ArrayList<String> authors = new ArrayList<String>();
    private String publisher;
    private Instant publishedDate;
    private String description;
    private List<BookIndustryIdentifierDto> industryIdentifiers = new ArrayList<BookIndustryIdentifierDto>();
    private Long pageCount;
    private List<String> categories = new ArrayList<String>();
    private ImageLinksDto imageLinks;
    private String language;
    private String previewLink;
    private String country;
    private String viewability;
    private boolean epubAvailable;
    private String coverUrl;
}