package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;

public class ComparisonByEdgeLength implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first.getEdgeLength()>second.getEdgeLength()) {
            return 1;
        }else if(first.getEdgeLength()<second.getEdgeLength()){
            return -1;
        }
        return 0;
    }
}
