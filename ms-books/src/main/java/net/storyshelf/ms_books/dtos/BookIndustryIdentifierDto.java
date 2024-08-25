package net.storyshelf.ms_books.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookIndustryIdentifierDto {
    private String type;
    private String identifier;
}