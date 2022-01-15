package com.yangsx95.proxy.statics;

public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy daoProxy = new Proxy(subject);
        String byId = daoProxy.findById(1L);
        System.out.println(byId);
    }
}
