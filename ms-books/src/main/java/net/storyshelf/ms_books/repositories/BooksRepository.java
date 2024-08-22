package net.storyshelf.ms_books.repositories;

import net.storyshelf.ms_books.entities.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends ElasticsearchRepository<Book, String> {
    @Query("""
        {
            "bool": {
                "must": [
                    { "query_string" : { "query" : "*?0*", "fields" : [ "title" ] } },
                    { "term": { "categories": "?1" } }
                ]
            }
        }
    """)
    Page<Book> findByTitleAndCategory(String title, String category, Pageable pageable);
    Page<Book> findByTitleContaining(String title, Pageable pageable);

    @Query("""
        {
            "bool": {
                "must": { "term": { "categories": "?0" } }
            }
        }
    """)
    Page<Book> findByCategory(String category, Pageable pageable);
}
