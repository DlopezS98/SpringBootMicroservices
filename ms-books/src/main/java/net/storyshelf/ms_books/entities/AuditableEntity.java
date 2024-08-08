package net.storyshelf.ms_books.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Nullable;
import java.time.Instant;

interface IHaveCreationData {
    public String createdBy = "";
    public Instant createdAt = Instant.now();
}

interface IHaveModificationData {
    public String updatedBy = "";
    public Instant updatedAt = null;
}

@EqualsAndHashCode(callSuper = true)
@Data
public class AuditableEntity extends BaseEntity implements IHaveCreationData, IHaveModificationData {
    //    @Field(type = FieldType.Keyword, fields = { @Field(type = FieldType.Keyword) })
    @Field(type = FieldType.Keyword)
    private String createdBy = "";
    @Nullable
    @Field(type = FieldType.Keyword)
    private String updatedBy = null;
/*
    @Field(type = FieldType.Keyword, name = "createdBy.keyword", ignoreAbove = 256)
    private String createdByKeyword;
*/

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant createdAt;
    @Nullable
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant updatedAt;
}
