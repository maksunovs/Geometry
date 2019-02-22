package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;

public class ComparisonByCoordinateY implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first.getPoint().getY()>second.getPoint().getY()) {
            return 1;
        }else if(first.getPoint().getY()<second.getPoint().getY()){
            return -1;
        }
        return 0;
    }

}
