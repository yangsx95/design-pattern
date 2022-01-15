package com.yangsx95.strategy;

import com.yangsx95.strategy.pojo.Cat;
import com.yangsx95.strategy.pojo.Dog;

/**
 * cat使用体重比较
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getWeight().equals(o2.getWeight()) ? 0 :
                (o1.getWeight() > o2.getWeight() ? 1 : -1);
    }
}
