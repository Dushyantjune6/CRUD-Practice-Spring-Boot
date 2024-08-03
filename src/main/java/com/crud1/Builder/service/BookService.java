package com.crud1.Builder.service;

import com.crud1.Builder.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Object> findById(Long id);

    List<Book> searchBooksByTitle(String title);

    void deleteBook(Long id);

    Book updateBook(Long id, Book bookDetails);

    Optional<Object> getBookById(Long id);

    Book createBook(Book book);
}
