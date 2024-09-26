package com.app.controllers;

import com.app.records.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class BookController {

    @Autowired
    Environment environment;

    @GetMapping("")
    public Book getCambio(

    ){
        var port = environment.getProperty("local.server.port");

        return new Book(
                1,
                "BRL",
                "USD",
                BigDecimal.valueOf(5.73),
                BigDecimal.valueOf(10),
                port
        );
    }
}
