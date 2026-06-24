package com.chirag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

        // get bean by id/name
        //OrderService order = (OrderService) context.getBean("orderService");

        //get bean by type
        //OrderService order = context.getBean(OrderService.class);

//        OrderService order = context.getBean("orderService",OrderService.class);
//        order.placeOrder();

        UserService user = context.getBean(UserService.class);
        context.close();
    }
}