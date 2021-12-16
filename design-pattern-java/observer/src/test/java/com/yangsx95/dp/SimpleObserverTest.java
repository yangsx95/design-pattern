package com.yangsx95.dp;

import java.util.ArrayList;
import java.util.List;

public class SimpleObserverTest {
    public static void main(String[] args) {
        // 创建观察者
        Observer o1 = new ConcreteObserver1();
        Observer o2 = new ConcreteObserver2();
        // 创建被观察者
        Subject s = new ConcreteSubject();
        // 添加观察者
        s.add(o1);
        s.add(o2);
        // 被观察者通知观察者
        s.notifyObserver();
    }
}

abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    /**
     * 增加一个观察者
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除一个观察者
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有观察者
     */
    public abstract void notifyObserver();

}

class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        this.observers.forEach(Observer::response);
    }
}

interface Observer {
    /**
     * 观察者做出反应
     */
    void response();
}

/**
 * 具体的一个观察者
 */
class ConcreteObserver1 implements Observer {

    @Override
    public void response() {
        System.out.println("观察者1做出反应");
    }
}

/**
 * 具体的一个观察者
 */
class ConcreteObserver2 implements Observer {

    @Override
    public void response() {
        System.out.println("观察者2做出反应");
    }
}


/*
运行结果：
观察者1做出反应
观察者2做出反应
 */