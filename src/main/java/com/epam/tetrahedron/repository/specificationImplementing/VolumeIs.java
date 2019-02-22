package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class VolumeIs implements Specification<Tetrahedron> {
    private final double expectedVolume;
    private final Calculator calculator;
    public VolumeIs(double expectedVolume, Calculator calculator) {
        this.calculator=calculator;
        this.expectedVolume = expectedVolume;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        double volume=calculator.getVolume(obj);
        return volume==expectedVolume;
    }
}
