package com.yourorg.library.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.yourorg.library.service.AuthorService;
import com.yourorg.library.repository.AuthorRepository;
import com.yourorg.library.entity.Author;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepo;

    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }
}