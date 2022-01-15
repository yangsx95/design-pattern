package com.yangsx95.notes.observer.v1;

import java.util.concurrent.TimeUnit;

/**
 * 爸爸持有孩子的对象，循环监控孩子的状态，当孩子哭了，就会调用feed方法喂食物
 */
public class Main {

    private static class Child {

        boolean cry = false;

        boolean isCry() {
            return cry;
        }

        public void cry() {
            this.cry = true;
        }
    }

    private static class Dad {

        private final Child child;

        public Dad(Child child) {
            this.child = child;
        }

        public void observer() throws Exception{
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                if (child.isCry()) {
                    feed();
                    break;
                }
            }
        }

        public void feed() {
            System.out.println("爸爸给孩子喂食物");
        }
    }

    public static void main(String[] args) throws Exception {
        Child child = new Child();
        child.cry();
        Dad dad = new Dad(child);
        dad.observer();
    }

}
