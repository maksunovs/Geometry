package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.specificationImplementing.SpecificationByID;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

public interface Repository <T extends Tetrahedron>{
    void add(T t);
    void add(Collection<T> t);
    void update(T t);
    void remove(int id);
    void remove(Specification<T> specification);
    List<T> query(Specification<T> specification);
    void sort(Comparator<T> comparator);
}
