package com.yourorg.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import com.yourorg.library.entity.Loan;
import com.yourorg.library.service.LoanService;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/issue")
    public Loan issueBook(@RequestParam Long memberId,
                          @RequestParam Long bookId,
                          @RequestParam LocalDate dueDate) {
        return loanService.issueBook(memberId, bookId, dueDate);
    }

    @PutMapping("/{loanId}/return")
    public Loan returnBook(@PathVariable Long loanId) {
        return loanService.returnBook(loanId);
    }
}