package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class VolumeIsMore implements Specification<Tetrahedron> {
    private final double leftBorder;
    private final Calculator calculator;
    public VolumeIsMore(double leftBorder, Calculator calculator) {
        this.calculator=calculator;
        this.leftBorder = leftBorder;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        double volume=calculator.getVolume(obj);
        return volume>leftBorder;
    }
}
