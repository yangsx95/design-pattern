package com.yangsx95.proxy.statics;

import java.util.ArrayList;
import java.util.List;

public class RealSubject implements Subject {
    @Override
    public void save(String target) {
        System.out.println("save success: " + target);
    }

    @Override
    public String findById(Long id) {
        return "张三";
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<String>() {{
            this.add("张三");
            this.add("李四");
            this.add("王五");
            this.add("赵六");
        }};
    }
}
