package net.storyshelf.ms_books.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
// @Setting(
// sortFields = {"title"},
// sortOrders = {Setting.SortOrder.desc, Setting.SortOrder.asc},
// sortMissingValues = {Setting.SortMissing._last, Setting.SortMissing._first}
// )
public class Book extends AuditableEntity {
    private String kind;
    private String etag;
    private String selfLink;
    @Field(type = FieldType.Keyword)
    private String title;
    private String subtitle;
    private ArrayList<String> authors = new ArrayList<String>();
    private String publisher;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Instant publishedDate;
    private String description;
    @Field(type = FieldType.Nested)
    private List<BookIndustryIdentifier> industryIdentifiers = new ArrayList<BookIndustryIdentifier>();
    @Field(type = FieldType.Integer)
    private Long pages;
    @Field(type = FieldType.Keyword)
    private List<String> categories = new ArrayList<String>();
    @Field(type = FieldType.Keyword)
    private String language;
    private String previewLink;
    @Field(type = FieldType.Keyword)
    private String country;
    @Field(type = FieldType.Keyword)
    private String viewability;
    private boolean epubAvailable;

    // ImageLinks Object Properties
    private String smallThumbnail;
    private String thumbnail;
    private String small;
    private String medium;
    private String large;
    private String extraLarge;

    @JsonIgnore
    public String getCoverUrl() {
        List<String> urls = Arrays.asList(extraLarge, large, medium, small, thumbnail, smallThumbnail);
        return urls.stream().filter(url -> !isNullOrEmpty(url)).findFirst().orElse("");
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}