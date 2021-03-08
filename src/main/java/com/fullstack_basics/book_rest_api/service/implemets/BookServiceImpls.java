package com.fullstack_basics.book_rest_api.service.implemets;

import java.util.List;
import com.fullstack_basics.book_rest_api.model.Book;
import com.fullstack_basics.book_rest_api.repository.BookRepository;
import com.fullstack_basics.book_rest_api.service.BookService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpls implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addData(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateData(Book book, int id) {
        Book exist = bookRepository.findById(id).orElse(null);
        if (exist != null) {
            exist.setAuthor(book.getAuthor());
            exist.setIsbnNumber(book.getIsbnNumber());
            exist.setLanguage(book.getLanguage());
            exist.setPrice(book.getPrice());
            exist.setTitle(book.getTitle());
            bookRepository.save(exist);
        }
        return exist;
    }

    @Override
    public String deleteData(int id) {
        JSONObject jsonObject = new JSONObject();
        try {
            bookRepository.deleteById(id);
            jsonObject.put("message", "Book deleted");
        } catch (JSONException e) {
            e.printStackTrace();
        }
       
        return jsonObject.toString();
    }

}
