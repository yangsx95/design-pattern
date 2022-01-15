package com.yangsx95.factorymethod.factory;

import com.yangsx95.product.Movable;

/**
 * 可移动生产工厂
 *
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public interface MovableFactory {

    Movable create();

}
