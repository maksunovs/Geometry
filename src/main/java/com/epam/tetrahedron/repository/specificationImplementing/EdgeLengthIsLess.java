package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class EdgeLengthIsLess implements Specification<Tetrahedron> {
    private final double rightBorder;
    public EdgeLengthIsLess(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        return obj.getEdgeLength()<rightBorder;
    }
}
