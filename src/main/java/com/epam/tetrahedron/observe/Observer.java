package com.epam.tetrahedron.observe;

import com.epam.tetrahedron.entity.Tetrahedron;

public interface Observer<T extends Tetrahedron> {
    void update(T t);
}
