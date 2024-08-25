package net.storyshelf.ms_writer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wish_list_items")
@EqualsAndHashCode(callSuper=false)
public class WishListItem extends AuditableEntity {
    private String bookId;
    private String bookTitle;
    private String bookCoverUrl;
}
