package net.storyshelf.ms_writer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode(callSuper = true)
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String coverUrl;
}
