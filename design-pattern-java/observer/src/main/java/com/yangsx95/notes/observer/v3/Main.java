package com.yangsx95.notes.observer.v3;

import java.util.Arrays;
import java.util.List;

/**
 * 使用接口抽象观察者
 * 被观察持有指定类型接口的所有观察者，当事件发生时，循环通知所有观察者
 */
public class Main {

    private interface ChildObserver {
        void actionOnChildCry();
    }

    private static class Child {
        boolean cry = false;
        private final List<ChildObserver> observers;

        Child(List<ChildObserver> observers) {
            this.observers = observers;
        }

        boolean isCry() {
            return cry;
        }

        public void cry() {
            this.cry = true;
            // 哭了，通知所有观察者
            observers.forEach(ChildObserver::actionOnChildCry);
        }
    }

    private static class Dad implements ChildObserver {
        @Override
        public void actionOnChildCry() {
            System.out.println("爸爸给孩子喂食物");
        }
    }

    private static class Mom implements ChildObserver{
        @Override
        public void actionOnChildCry() {
            System.out.println("妈妈给孩子抱抱");
        }
    }

    public static void main(String[] args) {
        Child child = new Child(Arrays.asList(new Dad(), new Mom()));
        child.cry();
    }

}
