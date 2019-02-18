package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;

import java.util.List;

public interface Repository <T extends Tetrahedron>{
    void add(T t);
    void update();
    void remove(int id);
    List<T> queru(Specification specification);

}
