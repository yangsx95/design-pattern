package com.yangsx95.simplefactory;

import com.yangsx95.product.Movable;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class Client {

    public static void main(String[] args) {
        Movable m = SimpleMovableFactory.create(SimpleMovableFactory.MOVABLE_TYPE_CAR);
        m.go();
    }

}
