package net.storyshelf.ms_books.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
@Setting(
        sortFields = {"title"},
        sortOrders = {Setting.SortOrder.desc, Setting.SortOrder.asc},
        sortMissingValues = {Setting.SortMissing._last, Setting.SortMissing._first}
)
public class Book extends AuditableEntity {
    @Field(type = FieldType.Keyword)
    private String title;
    private String author;
    @Field(type = FieldType.Keyword)
    private String isbn;
    @Field(type = FieldType.Integer)
    private int pages;
    private String coverUrl;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant publishDate;
    @Field(type = FieldType.Keyword)
    private List<String> categories = new ArrayList<String>();
}
