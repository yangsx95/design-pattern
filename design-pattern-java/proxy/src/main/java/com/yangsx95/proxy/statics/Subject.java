package com.yangsx95.proxy.statics;

import java.util.List;

public interface Subject {
    void save(String target);

    String findById(Long id);

    List<String> findAll();
}
