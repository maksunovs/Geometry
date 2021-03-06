package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class VolumeIsLess implements Specification<Tetrahedron> {
    private final double rightBorder;
    private final Calculator calculator;
    public VolumeIsLess(double rightBorder, Calculator calculator) {
        this.calculator=calculator;
        this.rightBorder = rightBorder;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        double volume=calculator.getVolume(obj);
        return volume<rightBorder;
    }
}
