package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;

public class ComparisonByVolume implements Comparator<Tetrahedron> {
    private final Calculator calculator;

    public ComparisonByVolume(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(calculator.getVolume(first)>calculator.getVolume(second)) {
            return 1;
        }else if(calculator.getVolume(first)<calculator.getVolume(second)){
            return -1;
        }
        return 0;
    }
}
