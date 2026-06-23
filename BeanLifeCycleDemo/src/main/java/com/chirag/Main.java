package com.chirag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();
//
//        AppConfig config = context.getBean(AppConfig.class);
//        config.demo();
//        UserService userService = context.getBean(UserService.class);
//        userService.setBeanName("BeanBean");

//        CartService cart = context.getBean(CartService.class);
//        System.out.println(cart.getValue(1));
//
//        context.close();



    }
}