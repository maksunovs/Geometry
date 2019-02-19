package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;

public interface Specification<T extends Tetrahedron> {
    boolean specified(T obj);
}
