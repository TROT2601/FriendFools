package com.jeremy.service;

import java.util.List;

public interface BaseService<C,I> {

    void create(C c);
    void update(C c);
    void delete(C c);

    List<C> findAll();
    C findById(I i);

    List<C> saveAll(List<C> c);

}
