package com.smart.payment.service;

import com.smart.payment.logger.TransactionLogger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService {

    private final TransactionLogger logger;

    public UpiPayment(TransactionLogger logger) {
        this.logger = logger;
        System.out.println("UpiPayment constructor called");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment: " + amount);
        logger.log("UPI Payment of " + amount + " processed");
    }
}