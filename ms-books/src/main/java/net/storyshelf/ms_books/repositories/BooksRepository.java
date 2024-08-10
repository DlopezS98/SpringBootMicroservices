package net.storyshelf.ms_books.repositories;

import net.storyshelf.ms_books.entities.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends ElasticsearchRepository<Book, String> {
}
