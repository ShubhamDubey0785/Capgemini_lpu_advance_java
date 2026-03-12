package com.yourorg.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourorg.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}