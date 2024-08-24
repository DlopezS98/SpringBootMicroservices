package net.storyshelf.ms_writer.entities;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

// interface IHaveCreationData {
//     public String createdBy = "";
//     public LocalDateTime createdAt = LocalDateTime.now();
// }

// interface IHaveModificationData {
//     public String updatedBy = "";
//     public LocalDateTime updatedAt = null;
// }


@Data
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
public abstract class AuditableEntity extends BaseEntity {
    private String createdBy = "";
    private LocalDateTime createdAt = LocalDateTime.now();
    private String updatedBy = "";
    private LocalDateTime updatedAt = null;
}
