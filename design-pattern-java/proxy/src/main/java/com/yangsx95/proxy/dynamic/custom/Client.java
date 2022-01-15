package com.yangsx95.proxy.dynamic.custom;

public class Client {

    public static void main(String[] args) throws Throwable{
        Subject subject = new RealSubject();
        SubjectHandler handler = new SubjectHandler(subject);
        MyClassLoader cl = new MyClassLoader();
        Subject s = (Subject) MyProxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
        s.request();
    }
}