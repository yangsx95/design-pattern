package com.yangsx95.simplefactory;

import com.yangsx95.product.Car;
import com.yangsx95.product.Movable;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class SimpleMovableFactory {

    public static final int MOVABLE_TYPE_CAR = 0;
    public static final int MOVABLE_TYPE_PLANE = 1;

    public static Movable create(int type) {
        switch (type) {
            case MOVABLE_TYPE_CAR:
                System.out.println("正在生产汽车");
                return new Car();
            case MOVABLE_TYPE_PLANE:
                System.out.println("正在生产飞机");
                return new Car();
            default:
                throw new IllegalArgumentException();
        }
    }

}
