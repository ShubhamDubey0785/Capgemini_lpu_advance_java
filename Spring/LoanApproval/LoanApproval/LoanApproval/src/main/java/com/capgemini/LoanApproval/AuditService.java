package com.capgemini.LoanApproval;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class AuditService {

    @PostConstruct
    public void init() {
        System.out.println("Audit Service Initialized");
    }

    public void audit(String message) {
        System.out.println("AUDIT LOG: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Audit Service Destroyed");
    }
}