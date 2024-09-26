package com.app.services;


import com.app.proxy.CambioProxy;
import com.app.records.Book;
import com.app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

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

}