package com.crud1.Builder.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Data
@Builder

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String title;

    @NotBlank(message = "Please provide a author name")
    String author;

    @Column(nullable = false, unique = true)
    String isbn;

    LocalDate publishedDate;
    Double price;


    public Book(Long id, String title, String author, String isbn, LocalDate publishedDate, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public Book() {
    }
}
