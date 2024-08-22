package net.storyshelf.ms_books.dtos;

import lombok.Data;

@Data
public class FilteredBookDto {
    private String search;
    private String category;
    private int limit;
    private int offset;
}
