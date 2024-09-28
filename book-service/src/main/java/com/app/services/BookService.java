package com.app.services;


import com.app.entity.BookEntity;
import com.app.proxy.CambioProxy;
import com.app.records.Book;
import com.app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class BookService{

    @Autowired
    private Environment environment;

    @Autowired
    private CambioProxy cambioProxy;

    @Autowired
    private BookRepository bookRepository;

    public Book getBook(String id, String toCurrency){
        var port = environment.getProperty("local.server.port");

        var book = bookRepository.findById(id)
                .orElseThrow();

        var cambio = cambioProxy.getCambio(book.getPrice().toString(),"USD",toCurrency);

        return new Book(
                book.getId(),
                book.getAuthor(),
                book.getLaunchDate(),
                cambio.convertedValue(),
                book.getTitle(),
                toCurrency,
                port);
    }

    public String insertDefaultBooks(){
        var calendar = Calendar.getInstance();

        var books = List.of(
                new BookEntity("George Orwell", calendar.getTime(), 39.90, "1984"),
                new BookEntity("J.K. Rowling", calendar.getTime(), 59.99, "Harry Potter and the Philosopher's Stone"),
                new BookEntity("J.R.R. Tolkien", calendar.getTime(), 49.99, "The Lord of the Rings: The Fellowship of the Ring"),
                new BookEntity("Gabriel García Márquez", calendar.getTime(), 34.50, "One Hundred Years of Solitude"),
                new BookEntity("F. Scott Fitzgerald", calendar.getTime(), 29.99, "The Great Gatsby"),
                new BookEntity("Harper Lee", calendar.getTime(), 24.99, "To Kill a Mockingbird"),
                new BookEntity("Jane Austen", calendar.getTime(), 19.90, "Pride and Prejudice"),
                new BookEntity("Herman Melville", calendar.getTime(), 44.90, "Moby Dick"),
                new BookEntity("Markus Zusak", calendar.getTime(), 39.50, "The Book Thief"),
                new BookEntity("Leo Tolstoy", calendar.getTime(), 54.99, "War and Peace")
        );

        bookRepository.saveAll(books);

        return "inserted successfully";
    }

    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }
}