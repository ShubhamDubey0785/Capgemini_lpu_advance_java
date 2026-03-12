package com.yourorg.library.service;

import com.yourorg.library.entity.Author;
import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthors();
}