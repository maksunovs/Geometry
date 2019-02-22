package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class SquareIsLess implements Specification<Tetrahedron> {
    private final double rightBorder;
    private final Calculator calculator;
    public SquareIsLess(double rightBorder, Calculator calculator) {
        this.rightBorder = rightBorder;
        this.calculator=calculator;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        double square = calculator.getSquare(obj);
        return square<rightBorder;
    }
}
