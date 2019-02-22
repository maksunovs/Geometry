package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class PointIs implements Specification<Tetrahedron> {
    private final Point point;
    public PointIs(Point point){
        this.point=point;
    }
    @Override
    public boolean specified(Tetrahedron obj) {
        Point objectPoint = obj.getPoint();
        return objectPoint.equals(point);
    }
}
