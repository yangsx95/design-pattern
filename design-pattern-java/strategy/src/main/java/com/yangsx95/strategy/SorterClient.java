package com.yangsx95.strategy;

import com.yangsx95.strategy.pojo.Cat;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public class SorterClient {

    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(
                new Cat("大脸猫", 10, 25),
                new Cat("虹猫", 8, 17),
                new Cat("Tom", 7, 20));

        SorterClient sc = new SorterClient();
        sc.sort(cats, new CatComparator());
        System.out.println(cats);

    }

    public <T> void sort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) < 0) {
                    T tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}
