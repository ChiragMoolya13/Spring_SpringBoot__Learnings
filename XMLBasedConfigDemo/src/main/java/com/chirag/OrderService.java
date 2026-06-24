package com.chirag;

import com.chirag.payment.PaymentService;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public OrderService(){
        System.out.println("order service created");
    }
    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
