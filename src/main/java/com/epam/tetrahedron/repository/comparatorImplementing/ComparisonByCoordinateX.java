package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;

public class ComparisonByCoordinateX implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first.getPoint().getX()>second.getPoint().getX()) {
            return 1;
        }else if(first.getPoint().getX()<second.getPoint().getX()){
            return -1;
        }
        return 0;
    }
}
