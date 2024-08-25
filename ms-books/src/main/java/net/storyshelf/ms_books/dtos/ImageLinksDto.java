package net.storyshelf.ms_books.dtos;

import lombok.Data;

@Data
public class ImageLinksDto {
    private String smallThumbnail;
    private String thumbnail;
    private String small;
    private String medium;
    private String large;
    private String extraLarge;
}