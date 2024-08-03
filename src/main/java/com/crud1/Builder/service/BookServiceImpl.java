package com.crud1.Builder.service;

import com.crud1.Builder.entity.Book;
import com.crud1.repository.BookRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Object> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.findById(id));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = (Book) bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishedDate(bookDetails.getPublishedDate());
        book.setPrice(bookDetails.getPrice());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = (Book) bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.delete(book);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }


}
