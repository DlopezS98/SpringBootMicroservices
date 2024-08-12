package net.storyshelf.ms_writer;

import net.storyshelf.ms_writer.entities.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
//@EnableDiscoveryClient
public class MsWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWriterApplication.class, args);
	}

	@GetMapping()
	public List<Book> hello() {
		return Book.getBooks();
	}
}
