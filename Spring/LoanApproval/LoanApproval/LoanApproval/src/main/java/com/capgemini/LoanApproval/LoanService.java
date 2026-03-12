package com.capgemini.LoanApproval;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.capgemini.LoanApproval.validator.LoanValidator;

@Component
public class LoanService {

    private final LoanValidator loanValidator;
    private AuditService auditService;

    // Constructor Injection + Qualifier
    public LoanService(
            @Qualifier("incomeValidator") LoanValidator loanValidator) {
        this.loanValidator = loanValidator;
    }

    // Setter Injection
    @Autowired
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void applyLoan(double amount) {

        System.out.println("Applying for loan: " + amount);

        boolean approved = loanValidator.validateLoan(amount);

        if (approved) {
            System.out.println("Loan Approved");
            auditService.audit("Loan Approved for amount: " + amount);
        } else {
            System.out.println("Loan Rejected");
            auditService.audit("Loan Rejected for amount: " + amount);
        }
    }
}