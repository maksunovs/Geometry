package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class EdgeLengthIsMore implements Specification<Tetrahedron> {
    private final double leftBorder;
    public EdgeLengthIsMore(double leftBorder) {
        this.leftBorder = leftBorder;
    }
    @Override
    public boolean specified(Tetrahedron obj) {
        return obj.getEdgeLength()>leftBorder;
    }
}
