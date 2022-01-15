package com.yangsx95.singleton;

/**
 * 懒汉式、线程安全, 双重检查锁方式
 * 为了解决S4的问题，我们可以在synchronized内部再判断一次, 既缩小了同步区域，又保证了不会被初始化多次
 * volatile用于禁止指令重排序
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S5_DoubleCheckLockImplement {

    private static volatile S5_DoubleCheckLockImplement INSTANCE;

    private S5_DoubleCheckLockImplement() {
    }

    public static S5_DoubleCheckLockImplement getInstance() {
        if (INSTANCE == null) {
            synchronized(S5_DoubleCheckLockImplement.class) {
                if (INSTANCE == null) {
                    INSTANCE = new S5_DoubleCheckLockImplement();
                }
            }
        }
        return INSTANCE;
    }

}
