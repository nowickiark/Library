package com.example.BookStore;

import com.example.BookStore.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(BookStoreApplication.class);

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) {
		orderService.action();
	}
}
