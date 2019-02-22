package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class SquareIs implements Specification<Tetrahedron> {
    private final double expectedSquare;
    private final Calculator calculator;
    public SquareIs(double expectedSquare, Calculator calculator) {
        this.expectedSquare = expectedSquare;
        this.calculator=calculator;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        double square = calculator.getSquare(obj);
        return square==expectedSquare;
    }
}
