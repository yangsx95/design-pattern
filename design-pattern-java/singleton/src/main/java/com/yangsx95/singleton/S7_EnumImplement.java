package com.yangsx95.singleton;

/**
 * 最完美的方式
 * 枚举实现，饿汉式，线程安全. 可防止反序列化(因为枚举类没有构造方法)
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public enum S7_EnumImplement {

    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
