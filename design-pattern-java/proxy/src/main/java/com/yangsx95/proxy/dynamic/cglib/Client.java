package com.yangsx95.proxy.dynamic.cglib;

public class Client {

    /**
     * cglib动态代理默认会代理被代理类的所有方法
     */
    public static void main(String[] args) throws Exception {
        SubjectHandler sh = new SubjectHandler();
        RealSubject instance = sh.getInstance();
        instance.request();
    }
}
