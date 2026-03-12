package com.yourorg.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourorg.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}