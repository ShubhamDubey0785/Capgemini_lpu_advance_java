package com.yourorg.library.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.yourorg.library.service.BookService;
import com.yourorg.library.repository.BookRepository;
import com.yourorg.library.entity.Book;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}