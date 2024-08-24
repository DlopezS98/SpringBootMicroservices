package net.storyshelf.ms_writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableDiscoveryClient
public class MsWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWriterApplication.class, args);
	}
}
