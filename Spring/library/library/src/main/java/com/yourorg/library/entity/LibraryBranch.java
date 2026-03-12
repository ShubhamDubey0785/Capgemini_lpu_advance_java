package com.yourorg.library.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String name;
    private String location;
    private String contactNumber;

    @OneToMany(mappedBy = "branch")
    private List<Book> books;
}