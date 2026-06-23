package com.chirag.simple;

public class B {

    private A a;

    public B(){
        System.out.println("A created");
        this.a = new A();
    }
}
