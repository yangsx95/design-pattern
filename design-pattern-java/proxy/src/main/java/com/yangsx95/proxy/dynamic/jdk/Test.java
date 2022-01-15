package com.yangsx95.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Test {


    /**
     * 查看代理对象的字节码
     */
    public static void main(String[] args) {

        Subject subject = new RealSubject();
        SubjectHandler handler = new SubjectHandler(subject);
        ClassLoader cl = subject.getClass().getClassLoader();
        Subject s = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{s.getClass()});
        try (FileOutputStream fos = new FileOutputStream("D:/$Proxy0.class")) {
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
