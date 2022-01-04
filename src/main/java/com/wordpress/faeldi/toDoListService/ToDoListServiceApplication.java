package com.wordpress.faeldi.toDoListService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ToDoListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListServiceApplication.class, args);
	}

}
