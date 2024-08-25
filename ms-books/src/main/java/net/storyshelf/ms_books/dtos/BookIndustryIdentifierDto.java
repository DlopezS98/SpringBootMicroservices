package net.storyshelf.ms_books.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookIndustryIdentifierDto {
    private String type;
    private String identifier;
}