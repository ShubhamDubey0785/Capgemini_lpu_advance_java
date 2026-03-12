package com.smart.payment;

import com.smart.payment.config.AppConfig;
import com.smart.payment.processor.PaymentProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PaymentApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor processor = context.getBean(PaymentProcessor.class);

        processor.execute(2000);

        context.close();
    }
}