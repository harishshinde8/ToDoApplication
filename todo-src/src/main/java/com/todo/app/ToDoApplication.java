package com.todo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.todo.app.service.ToDoService;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ToDoApplication.class, args);
		
		ToDoService productService = applicationContext.getBean(ToDoService.class);
		productService.saveInitialBatch();

	}
}
