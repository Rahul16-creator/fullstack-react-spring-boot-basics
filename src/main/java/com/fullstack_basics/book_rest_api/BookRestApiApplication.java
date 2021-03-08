package com.fullstack_basics.book_rest_api;

import com.fullstack_basics.book_rest_api.model.Book;
import com.fullstack_basics.book_rest_api.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookRestApiApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(BookRestApiApplication.class, args);
		System.out.println("All method executed successfully!!..");
	}

	@Override
	public void run(String... args) throws Exception {
		Book book  = new Book();
		book.setAuthor("Auth");
		book.setLanguage("language-1");
		book.setPrice(100.05);
		book.setTitle("title-1");
		book.setIsbnNumber((long) 3456);
		bookService.addData(book);
		
	}

}
