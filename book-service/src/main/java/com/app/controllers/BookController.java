package com.app.controllers;

import com.app.entity.BookEntity;
import com.app.records.Book;
import com.app.repositories.BookRepository;
import com.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book-service")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("insert")
    String insertDefaultBooks(){
        return bookService.insertDefaultBooks();
    }

    @GetMapping("{id}/{to_currency}")
    public Book getBook(
        @PathVariable(value = "id") String id,
        @PathVariable(value = "to_currency") String toCurrency
    ){
        return bookService.getBook(id,toCurrency);
    }

    @GetMapping("list")
    public List<BookEntity> getBooks(){
        return bookService.getBooks();
    }
}
