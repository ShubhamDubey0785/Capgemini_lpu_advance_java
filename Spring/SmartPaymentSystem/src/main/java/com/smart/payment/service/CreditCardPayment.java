package com.smart.payment.service;

import com.smart.payment.logger.TransactionLogger;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService{

    private final TransactionLogger logger;

    public CreditCardPayment(TransactionLogger logger) {
        this.logger = logger;
        System.out.println("CreditCardPayment constructor called");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment: " + amount);
        logger.log("Credit Card Payment of " + amount + " processed");
    }
}