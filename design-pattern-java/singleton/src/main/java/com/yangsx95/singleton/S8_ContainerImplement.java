package com.yangsx95.singleton;

import java.util.*;

/**
 * 容器单例， 比如spring容器
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/11
 */
public class S8_ContainerImplement {

    private static List<S8_ContainerImplement> set = new ArrayList<>();

    static {
        set.add(new S8_ContainerImplement());
    }

    public static S8_ContainerImplement getInstance() {
        return set.get(0);
    }
}
