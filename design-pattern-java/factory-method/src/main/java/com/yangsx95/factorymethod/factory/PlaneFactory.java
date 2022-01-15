package com.yangsx95.factorymethod.factory;

import com.yangsx95.product.Movable;
import com.yangsx95.product.Plane;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class PlaneFactory implements MovableFactory  {
    @Override
    public Movable create() {
        System.out.println("正在生产飞机...");
        return new Plane();
    }
}
