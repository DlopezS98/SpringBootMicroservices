package net.storyshelf.ms_writer.entities;

import java.time.LocalDateTime;

interface IHaveCreationData {
    public String createdBy = "";
    public LocalDateTime createdAt = LocalDateTime.now();
}

interface IHaveModificationData {
    public String updatedBy = "";
    public LocalDateTime updatedAt = null;
}

public class AuditableEntity extends BaseEntity implements IHaveCreationData, IHaveModificationData { }
