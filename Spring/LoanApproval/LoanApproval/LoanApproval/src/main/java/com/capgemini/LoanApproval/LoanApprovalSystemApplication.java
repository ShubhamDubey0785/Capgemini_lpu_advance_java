package com.capgemini.LoanApproval;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.LoanApproval.LoanService;

@SpringBootApplication
public class LoanApprovalSystemApplication implements CommandLineRunner {

    @Autowired
    private LoanService loanService;

    public static void main(String[] args) {
        SpringApplication.run(LoanApprovalSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        loanService.applyLoan(250000);
    }
}
