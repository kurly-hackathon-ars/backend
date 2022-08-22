package com.crawling.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@EnableJpaAuditing
@SpringBootApplication
public class ItemApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ItemApplication.class, args);
	}

}
