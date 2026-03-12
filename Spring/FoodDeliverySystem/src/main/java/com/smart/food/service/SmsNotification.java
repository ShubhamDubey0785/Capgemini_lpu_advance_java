package com.smart.food.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SmsNotification implements NotificationService {

    public SmsNotification() {
        System.out.println("SmsNotification constructor called");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Sent: " + message);
    }
}