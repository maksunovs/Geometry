package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;

public interface Comparator<T extends Tetrahedron> {
    int compare(T first,T second);
}
