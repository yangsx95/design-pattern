package com.yangsx95.singleton;

/**
 * 懒汉式、线程安全
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S3_LazyThreadSafeImplement {

    private static S3_LazyThreadSafeImplement INSTANCE;

    private S3_LazyThreadSafeImplement() {
    }

    public static synchronized S3_LazyThreadSafeImplement getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new S3_LazyThreadSafeImplement();
        }
        return INSTANCE;
    }

}
