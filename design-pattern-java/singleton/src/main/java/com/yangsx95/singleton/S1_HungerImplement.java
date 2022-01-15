package com.yangsx95.singleton;

/**
 * 静态变量实现方式、线程安全、饿汉式； 是最常用的一种方式
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S1_HungerImplement {

    private static final S1_HungerImplement INSTANCE = new S1_HungerImplement();

/*    static {
        INSTANCE = new S1_StaticFieldImplements();
    }*/

    private S1_HungerImplement() {
    }

    public static S1_HungerImplement getInstance() {
        return INSTANCE;
    }
}
