package com.yourorg.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import com.yourorg.library.entity.*;
import com.yourorg.library.repository.*;
import com.yourorg.library.service.LoanService;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    @Override
    public Loan issueBook(Long memberId, Long bookId, LocalDate dueDate) {

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if(book.getCopiesAvailable() <= 0)
            throw new RuntimeException("No copies available");

        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Loan loan = new Loan();
        loan.setIssueDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setLoanStatus("ISSUED");
        loan.setBook(book);
        loan.setMember(member);

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepo.save(book);   // 👈 IMPORTANT ADD THIS

        return loanRepo.save(loan);
    }

    @Override
    public Loan returnBook(Long loanId) {

        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setReturnDate(LocalDate.now());
        loan.setLoanStatus("RETURNED");

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        bookRepo.save(book);   // 👈 ALSO ADD THIS

        return loanRepo.save(loan);
    }
    @Override
    public java.util.List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }
}