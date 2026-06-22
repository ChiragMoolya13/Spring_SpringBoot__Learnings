package com.chirag;

import com.chirag.payment.CardPayment;
import com.chirag.payment.PaymentService;
import com.chirag.payment.UpiPayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.chirag")
public class AppConfig {
    @Bean
    public User createUser(){
         return new User("Chirag", 31);
    }

    @Bean
    @Primary
    public PaymentService createCardPayment(){
        return new CardPayment();
    }

    @Bean
    public PaymentService createUpiPayment(){
        return new UpiPayment();
    }

    public OrderService createOrderService(PaymentService paymentService){
        return new OrderService(paymentService);
    }
}
