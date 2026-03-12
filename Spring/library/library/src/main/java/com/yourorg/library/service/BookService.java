package com.yourorg.library.service;

import com.yourorg.library.entity.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
}