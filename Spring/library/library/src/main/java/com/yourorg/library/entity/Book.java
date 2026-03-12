package com.yourorg.library.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;

    @Column(unique = true)
    private String isbn;

    private int publishYear;
    private int copiesTotal;
    private int copiesAvailable;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private LibraryBranch branch;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;
}