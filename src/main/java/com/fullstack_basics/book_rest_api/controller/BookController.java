package com.fullstack_basics.book_rest_api.controller;

import com.fullstack_basics.book_rest_api.model.Book;
import com.fullstack_basics.book_rest_api.service.BookService;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Book>> findAll() {
        LOGGER.info("executing findAll");
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        LOGGER.info("executing findById");
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> addData(@RequestBody Book book) {
        LOGGER.info("executing addData");
        return new ResponseEntity<>(bookService.addData(book), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> updateData(@RequestBody Book book, @PathVariable int id) {
        LOGGER.info("executing updateData");
        return new ResponseEntity<>(bookService.updateData(book, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteData(@PathVariable int id) {
        LOGGER.info("executing deleteData");
        return new ResponseEntity<>(bookService.deleteData(id), HttpStatus.OK);
    }

    @GetMapping("/invalid")
    public String invalid() {
        LOGGER.info("executing invalid");
        return "{'message', 'SOMETHING WENT WRONG'}";
    }
}
