package com.yangsx95.singleton;

/**
 * 懒汉式、线程安全, 减少了同步代码快的区域
 * 此模式有问题，当多线程并发访问有问题，因为判断与初始化不是一个原子操作，有可能初始化多次
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S4_LazyThreadSafeImplement2 {

    private static S4_LazyThreadSafeImplement2 INSTANCE;

    private S4_LazyThreadSafeImplement2() {
    }

    public static S4_LazyThreadSafeImplement2 getInstance() {
        if (INSTANCE == null) {
            synchronized (S4_LazyThreadSafeImplement2.class) {
                INSTANCE = new S4_LazyThreadSafeImplement2();
            }
        }
        return INSTANCE;
    }

}
