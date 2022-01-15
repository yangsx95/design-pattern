package com.yangsx95.singleton;

/**
 * 静态内部类方式，懒汉式，线程安全
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S6_StaticInnerClassImplement {

    private S6_StaticInnerClassImplement() {
    }

    private interface InstanceHolder {
        S6_StaticInnerClassImplement INSTANCE = new S6_StaticInnerClassImplement();
    }

    // 当调用了getInstance方法时，类加载器才会去加载InstanceHolder类，从而才会初始化成员 INSTANCE
    public static S6_StaticInnerClassImplement getInstance() {
        return InstanceHolder.INSTANCE;
    }

}
