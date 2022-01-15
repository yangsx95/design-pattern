package com.yangsx95.factorymethod.factory;

import com.yangsx95.product.Car;
import com.yangsx95.product.Movable;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class CarFactory implements MovableFactory {
    @Override
    public Movable create() {
        System.out.println("正在生产汽车...");
        return new Car();
    }

}
