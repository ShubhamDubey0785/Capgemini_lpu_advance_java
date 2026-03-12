package com.smart.payment.processor;

import com.smart.payment.logger.TransactionLogger;
import com.smart.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    private final PaymentService paymentService;

    @Autowired
    private TransactionLogger logger;   // Field Injection

    public PaymentProcessor(@Qualifier("upiPayment") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void execute(double amount) {
        paymentService.processPayment(amount);
        logger.log("Payment execution completed");
    }
}