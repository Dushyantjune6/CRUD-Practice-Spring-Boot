package com.crud1.Builder.controller;

import com.crud1.Builder.entity.Book;
import com.crud1.Builder.service.BookService;
import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookControllers {

    @Autowired
    private BookService bookService;
    @PostMapping("/save")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/get")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long id) {
        Book book = (Book) bookService.getBookById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long id, @Valid @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam(value = "title") String title) {
        return bookService.searchBooksByTitle(title);
    }
}
