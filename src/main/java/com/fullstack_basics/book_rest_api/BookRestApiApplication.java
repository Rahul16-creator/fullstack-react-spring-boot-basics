package com.fullstack_basics.book_rest_api;

import com.fullstack_basics.book_rest_api.model.Book;
import com.fullstack_basics.book_rest_api.model.Role;
import com.fullstack_basics.book_rest_api.model.User;
import com.fullstack_basics.book_rest_api.service.BookService;
import com.fullstack_basics.book_rest_api.service.RoleService;
import com.fullstack_basics.book_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookRestApiApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookRestApiApplication.class, args);
		System.out.println("All method executed successfully!!..");
	}

	@Override
	public void run(String... args) throws Exception {

		Role role = new Role();
		role.setName("admin");
		// roleService.addData(role);

		User user = new User();
		user.setName("Rahul");
		user.setEmail("test@admin.com");
		user.setPassword(new BCryptPasswordEncoder().encode("test"));
		user.setPhone((long) 23456);
		user.setRole(roleService.findById(1));
		// userService.addData(user);

		Book book = new Book();
		book.setAuthor("Auth");
		book.setLanguage("language-1");
		book.setPrice(100.05);
		book.setTitle("title-1");
		book.setIsbnNumber((long) 3456);
		bookService.addData(book);

	}

}
