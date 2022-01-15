package com.yangsx95.proxy.dynamic.custom;


import java.lang.reflect.Method;

public class SubjectHandler implements MyInvocationHandler {

    private Subject subject;

    public SubjectHandler(Subject subject) {
        this.subject = subject;
    }

    // 委托处理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----即将调用方法" + method.getName());
        method.invoke(subject, args);
        System.out.println("----调用方法" + method.getName() + "结束");
        System.out.println(proxy);
        return null;
    }
}
