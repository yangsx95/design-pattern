package com.yangsx95.proxy.dynamic;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("我是realRequest方法");
    }
}
