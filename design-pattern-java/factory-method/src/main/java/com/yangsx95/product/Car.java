package com.yangsx95.product;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class Car implements Movable {
    @Override
    public void go() {
        System.out.println("汽车 呜呜呜~~~");
    }
}
