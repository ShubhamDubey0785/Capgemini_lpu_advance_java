package com.yourorg.library.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String email;
    private String phone;

    private LocalDate memberSince;
    private String status;

    @OneToMany(mappedBy = "member")
    private List<Loan> loans;
}