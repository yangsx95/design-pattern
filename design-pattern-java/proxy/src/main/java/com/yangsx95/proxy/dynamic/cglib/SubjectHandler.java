package com.yangsx95.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SubjectHandler implements MethodInterceptor {

    // 和jdk动态代理相同，同样是做了字节码重组的工作
    // 和jdk动态代理不同，cglib不需要实现任何接口就可以对目标类进行代理，与jdk代理相比，用户是无感知的
    // cglib代理通过继承被代理类，来创建代理类。 即代理类继承被代理类
    
    // jdk是交给兄弟处理
    // cglib是交给儿子处理
    
    /**
     * @param o 被代理实例
     * @param method 方法
     * @param objects 参数
     * @param methodProxy 
     * @return 方法调用返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("即将调用request方法--");
        // 调用代理类父类（被代理类的方法）
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("调用request方法结束");
        return invoke;
    }

    /**
     * 获取代理实例对象
     * @return 实例对象
     */
    public RealSubject getInstance() throws Exception {
        Enhancer enhancer = new Enhancer();
        // 告诉cglib，生成的代理类，需要继承哪个类
        enhancer.setSuperclass(RealSubject.class);
        // 设置回调，这里需要回调 intercept 方法
        enhancer.setCallback(this);
        
        // create ----
        // 1. 生成源代码
        // 2. 编译为class
        // 3. 加载到jvm 并返回被代理对象
        return (RealSubject) enhancer.create();
    }
}
