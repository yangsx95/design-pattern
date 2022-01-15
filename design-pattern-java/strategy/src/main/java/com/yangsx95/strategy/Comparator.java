package com.yangsx95.strategy;

/**
 * @author yangsx
 * @version 1.0
 * @date 2019/9/13
 */
public interface Comparator<T> {
    int compare(T o1, T o2);
}
