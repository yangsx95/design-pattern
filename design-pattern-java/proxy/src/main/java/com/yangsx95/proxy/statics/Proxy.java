package com.yangsx95.proxy.statics;

import java.util.List;

public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        System.err.println("----初始化Dao");
        this.subject = subject;
    }

    @Override
    public void save(String target) {
        System.err.println("----save " + target);
        subject.save(target);
    }

    @Override
    public String findById(Long id) {
        System.err.println("----findById " + id);
        return subject.findById(id);
    }

    @Override
    public List<String> findAll() {
        System.err.println("---findAll ");
        return subject.findAll();
    }
}
