package com.yangsx95.singleton;

/**
 * 懒汉式，线程不安全
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S2_LazyLoadingImplement {

    private static S2_LazyLoadingImplement INSTANCE;

    private S2_LazyLoadingImplement() {
    }

    public static S2_LazyLoadingImplement getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new S2_LazyLoadingImplement();
        }
        return INSTANCE;
    }

}
