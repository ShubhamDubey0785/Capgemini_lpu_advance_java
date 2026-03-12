package com.smart.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final NotificationService notificationService;

    @Autowired
    private RestaurantService restaurantService;

    public OrderService(
            @Qualifier("smsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Order Placed");
        restaurantService.prepareOrder();
        notificationService.sendNotification("Your order is on the way!");
    }
}