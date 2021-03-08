package com.fullstack_basics.book_rest_api.service;

import java.util.*;
import com.fullstack_basics.book_rest_api.model.Book;

public interface BookService {

    List<Book> findAll();

    Book findById(int id);

    Book addData(Book book);

    Book updateData(Book book, int id);

    String deleteData(int id);

}
