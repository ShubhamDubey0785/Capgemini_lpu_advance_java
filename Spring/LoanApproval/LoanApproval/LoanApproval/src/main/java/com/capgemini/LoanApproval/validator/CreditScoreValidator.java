package com.capgemini.LoanApproval.validator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator {

    public CreditScoreValidator() {
        System.out.println("CreditScoreValidator Bean Created");
    }

    @Override
    public boolean validateLoan(double amount) {
        System.out.println("Validating using Credit Score...");
        return amount <= 500000;
    }
}