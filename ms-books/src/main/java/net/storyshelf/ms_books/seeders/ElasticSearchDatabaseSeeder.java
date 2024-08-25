package net.storyshelf.ms_books.seeders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.storyshelf.ms_books.dtos.CreateBookDto;
import net.storyshelf.ms_books.entities.Book;
import net.storyshelf.ms_books.mappers.BookEntityMapper;
import net.storyshelf.ms_books.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class ElasticSearchDatabaseSeeder {
    private final BooksRepository booksRepository;
    private static final Logger logger = Logger.getLogger(ElasticSearchDatabaseSeeder.class.getName());

    @Value("classpath:data/books-seeder.json")
    Resource booksSeederResource;

    @PostConstruct
    public void init() throws IOException {
        logger.info("Initializing ElasticSearch database");
        long totalCount = booksRepository.count();

        logger.info("Total number of books: <<" + totalCount + ">>");
        if (totalCount > 0) return;

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<CreateBookDto>> typeReference = new TypeReference<>() {};
        InputStream inputStream = booksSeederResource.getInputStream();
        List<CreateBookDto> bookDtos = mapper.readValue(inputStream, typeReference);

        List<Book> books = bookDtos.stream().map(BookEntityMapper::from).toList();
        booksRepository.saveAll(books);

        logger.info("Data loaded successfully: " + books.size() + " books");
    }
}
