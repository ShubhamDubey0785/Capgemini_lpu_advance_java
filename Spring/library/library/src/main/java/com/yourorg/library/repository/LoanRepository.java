package com.yourorg.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourorg.library.entity.Loan;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Custom Query Method
    List<Loan> findByMemberMemberId(Long memberId);
}