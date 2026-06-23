package com.chirag.simple;

public class A {

    private B b;

    public A(){
        System.out.println("B created");
        this.b = new B();
    }
}
