package net.storyshelf.ms_writer.entities;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

interface IHaveCreationData {
    public String createdBy = "";
    public LocalDateTime createdAt = LocalDateTime.now();
}

interface IHaveModificationData {
    public String updatedBy = "";
    public LocalDateTime updatedAt = null;
}

@Data
@EqualsAndHashCode(callSuper=false)
public class AuditableEntity extends BaseEntity implements IHaveCreationData, IHaveModificationData { }
