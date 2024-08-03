package com.crud1.repository;

import com.crud1.Builder.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByTitleContaining(String title);
    void deleteById(Long id);
    Optional<Book> findById(Long id);
    Book save(Book book);
    List<Book> findAll();
}
