package com.yangsx95.proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        // 创建`调用处理器`，代理对象需要`调用处理器`，调用委托对象的方法
        SubjectHandler handler = new SubjectHandler(subject);
        // 获取类加载器
        ClassLoader cl = subject.getClass().getClassLoader();
        // 生成代理对象，需要调用newProxyInstance方法传入类加载器、目标类实现的所有接口、InvocationHandler实例
        // 返回一个Object的代理实例
        Subject s = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
        s.request();

        // 查看代理类的类型
        Class proxyClass = s.getClass();
        System.out.println(proxyClass);
        // 查看他的父类
        Class superclass = proxyClass.getSuperclass();
        System.out.println(superclass);
        // 查看他的所有接口
        Class[] interfaces = proxyClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
    }
}
