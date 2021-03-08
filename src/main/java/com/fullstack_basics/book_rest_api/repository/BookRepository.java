package com.fullstack_basics.book_rest_api.repository;

import com.fullstack_basics.book_rest_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    
}
