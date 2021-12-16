abstract class Subject {

    protected observers: Array<Observer> = new Array<Observer>()

    /**
     * 增加一个观察者
     */
    public add(observer: Observer) {
        this.observers.push(observer)
    }

    /**
     * 移除一个观察者
     * @param observer
     */
    public remove(observer: Observer) {
        let index = this.observers.indexOf(observer)
        if (index < 0) {
            return
        }
        this.observers.splice(index, 1)
    }
    
    public abstract notifyObserver()

}

class ConcreteSubject extends Subject {
    
    notifyObserver() {
        this.observers.forEach((e) => e.response())
    }
    
}

interface Observer {

    /**
     * 观察者做出反应
     */
    response()

}

class Observer1 implements Observer {

    response() {
        console.log("观察者1做出反应")
    }

}

class Observer2 implements Observer {
    response() {
        console.log("观察者2做出反应")
    }
}


// main
// 创建观察者
let o1: Observer = new Observer1();
let o2: Observer = new Observer2();
// 创建被观察者
let s: Subject = new ConcreteSubject();
// 添加观察者
s.add(o1);
s.add(o2);
// 通知所有观察者
s.notifyObserver();

/*
执行结果：
观察者1做出反应
观察者2做出反应
 */