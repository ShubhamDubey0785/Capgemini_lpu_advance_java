package com.yourorg.library.service;

import com.yourorg.library.entity.Loan;
import java.util.List;

public interface LoanService {
    Loan issueBook(Long memberId, Long bookId, java.time.LocalDate dueDate);
    Loan returnBook(Long loanId);
    List<Loan> getAllLoans();
}