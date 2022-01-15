package com.yangsx95.strategy;

import com.yangsx95.strategy.pojo.Dog;

/**
 * dog使用food的多少比较
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getFood().equals(o2.getFood()) ? 0 :
                (o1.getFood() > o2.getFood() ? 1 : -1);
    }
}
