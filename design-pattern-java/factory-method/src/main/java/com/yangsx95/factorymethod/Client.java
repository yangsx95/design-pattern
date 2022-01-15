package com.yangsx95.factorymethod;

import com.yangsx95.factorymethod.factory.CarFactory;
import com.yangsx95.product.Movable;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class Client {

    public static void main(String[] args) {
        Movable m = new CarFactory().create();
        m.go();
    }

}
