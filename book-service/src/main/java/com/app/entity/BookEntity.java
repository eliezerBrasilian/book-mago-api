package com.app.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Setter
@Getter
@Document(value = "books")
@EqualsAndHashCode(of = "id")
public class BookEntity {
    @Id
    private String id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    public BookEntity(String author, Date launchDate, Double price, String title){
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }
}
