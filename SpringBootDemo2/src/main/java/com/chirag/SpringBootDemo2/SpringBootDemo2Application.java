package com.chirag.SpringBootDemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemo2Application {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootDemo2Application.class, args);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();
	}

//    @Bean
//    public JsonParser getJsonParserBean(){
//        return new BasicJsonParser();
//    }

}
