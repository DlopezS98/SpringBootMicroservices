package net.storyshelf.ms_books.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseEntity {
    @Id
    private String id;
}
