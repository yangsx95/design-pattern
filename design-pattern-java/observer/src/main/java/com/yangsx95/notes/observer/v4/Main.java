package com.yangsx95.notes.observer.v4;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * 抽象事件对象，当小孩哭的时候，我们可能需要根据哭声的大小，哭的时间等信息
 * 抽象一个事件对象，通常事件对象中包含一个Source事件源对象（时间发出的对象），以及事件的上下文信息
 *
 * 更近一步可以对Event进行抽象，让其拥有继承关系
 */
public class Main {

    private interface ChildObserver {
        void actionOnChildCry(CryEvent event);
    }

    private static class CryEvent {
        // 哭的小孩
        Child source;
        // 哭的声音的大小
        int large;
        // 哭的时间
        LocalTime cryTime;
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
            observers.forEach(e -> {
                CryEvent event = new CryEvent();
                event.cryTime = LocalTime.now();
                event.large = 999;
                event.source = this;
                e.actionOnChildCry(event);
            });
        }
    }

    private static class Dad implements ChildObserver {
        @Override
        public void actionOnChildCry(CryEvent event) {
            if (event.large > 100) { // 哭的声音很大就打孩子
                System.out.println("爸爸给打孩子");
            } else {
                System.out.println("爸爸给孩子喂食物");
            }

        }
    }

    private static class Mom implements ChildObserver {
        @Override
        public void actionOnChildCry(CryEvent event) {
            if (event.cryTime.getHour() == 1) { // 如果是半夜一点
                System.out.println("妈妈打孩子");
            } else {
                System.out.println("妈妈给孩子抱抱");
            }
        }
    }

    public static void main(String[] args) {
        Child child = new Child(Arrays.asList(new Dad(), new Mom()));
        child.cry();
    }

}
