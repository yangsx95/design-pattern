package com.yangsx95.proxy.dynamic.custom;

import java.lang.reflect.Method;

/**
 * 自定义代理
 */
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
