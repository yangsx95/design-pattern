package com.yangsx95.notes.observer.v2;

import java.util.concurrent.TimeUnit;

/**
 * 孩子持有爸爸妈妈的引用，当孩子哭了的时候，调用爸爸的方法通知爸爸妈妈喂食、以及抱抱
 * 缺点，被观察者孩子与观察者父母耦合过高，当出现新的观察者时，需要修改Child类
 */
public class Main {

    private static class Child {

        boolean cry = false;

        private final Dad dad;
        private final Mom mom;

        Child(Dad dad, Mom mom) {
            this.dad = dad;
            this.mom = mom;
        }

        boolean isCry() {
            return cry;
        }

        public void cry() {
            this.cry = true;
            // 哭了，通知父母操作
            dad.feed();
            mom.hug();
        }
    }

    private static class Dad {
        public void feed() {
            System.out.println("爸爸给孩子喂食物");
        }
    }

    private static class Mom {
        public void hug() {
            System.out.println("妈妈给孩子抱抱");
        }
    }

    public static void main(String[] args) {
        Child child = new Child(new Dad(), new Mom());
        child.cry();
    }

}
