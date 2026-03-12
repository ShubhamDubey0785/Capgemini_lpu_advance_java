package com.smart.food;

import com.smart.food.config.FoodAppConfig;
import com.smart.food.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FoodApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(FoodAppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        orderService.placeOrder();

        context.close();
    }
}