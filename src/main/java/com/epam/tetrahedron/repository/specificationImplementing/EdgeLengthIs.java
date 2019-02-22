package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class EdgeLengthIs implements Specification<Tetrahedron> {
    private final double expectedLength;
    public EdgeLengthIs(double expectedLength) {

        this.expectedLength = expectedLength;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        return obj.getEdgeLength()==expectedLength;
    }
}
