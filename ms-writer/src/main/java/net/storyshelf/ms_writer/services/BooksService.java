package net.storyshelf.ms_writer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.storyshelf.ms_writer.dtos.BookDto;

// Infrastructure layer: service for books
@Service
@Slf4j
@RequiredArgsConstructor
public class BooksService {
    @Value("${storyshelf.services.books.url}")
    private String booksServiceUrl;

    private final RestTemplate restTemplate;

    public Optional<BookDto> getById(String id) {
        String url = booksServiceUrl + "/api/books/" + id;
        try {
            return Optional.ofNullable(restTemplate.getForObject(url, BookDto.class));
        } catch (Exception e) {
            log.error("Error while fetching book from books service", e);
            return Optional.empty();
        }
    }
}
