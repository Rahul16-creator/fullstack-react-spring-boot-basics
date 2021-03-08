package com.fullstack_basics.book_rest_api.controller;

import com.fullstack_basics.book_rest_api.model.Book;
import com.fullstack_basics.book_rest_api.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return bookService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Book addData(@RequestBody Book book) {
        return bookService.addData(book);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Book updateData(@RequestBody Book book, @PathVariable int id) {
        return bookService.updateData(book, id);
    }

    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable int id) {
        return bookService.deleteData(id);
    }

}
