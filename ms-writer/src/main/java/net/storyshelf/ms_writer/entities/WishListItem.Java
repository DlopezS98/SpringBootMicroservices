package net.storyshelf.ms_writer.entities;

import jakarta.persistence.Table;
import lombok.*;

@Table(name = "wish_list_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class WishListItem extends AuditableEntity {
    private String bookId;
    private String bookTitle;
    private String bookCoverUrl;
}
