package com.app.controllers;

import com.app.entity.BookEntity;
import com.app.records.Book;
import com.app.repositories.BookRepository;
import com.app.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Insere livros padrões", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inserção realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Chave de API inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar inserção dos livros")
    })
    @Parameter(
            name = "X-API-KEY",
            description = "Chave de API necessária para realizar a inserção dos livros",
            required = true,
            in = ParameterIn.HEADER
    )
    @PostMapping("insert")
    String insertDefaultBooks(){
        return bookService.insertDefaultBooks();
    }

    @Operation(summary = "Busca livros de profissionais pelo id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos livros"),
    })
    @GetMapping("{id}/{to_currency}")
    public Book getBook(
        @PathVariable(value = "id") String id,
        @PathVariable(value = "to_currency") String toCurrency
    ){
        return bookService.getBook(id,toCurrency);
    }

    @Operation(summary = "Busca todos os livros", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos livros"),
    })
    @GetMapping("list")
    public List<BookEntity> getBooks(){
        return bookService.getBooks();
    }
}
