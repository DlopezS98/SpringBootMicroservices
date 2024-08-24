package net.storyshelf.ms_writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "net.storyshelf.ms_writer.repositories")
public class MsWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWriterApplication.class, args);
	}
}
