package net.storyshelf.ms_books.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryResult<T> {
    private Long totalCount;
    private List<T> items;
}
