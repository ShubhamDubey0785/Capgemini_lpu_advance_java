package com.yourorg.library.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter @Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String name;
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}