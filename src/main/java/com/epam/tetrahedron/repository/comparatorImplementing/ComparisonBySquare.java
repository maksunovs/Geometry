package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;

public class ComparisonBySquare implements Comparator<Tetrahedron> {
    private final Calculator calculator;

    public ComparisonBySquare(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(calculator.getSquare(first)>calculator.getSquare(second)) {
            return 1;
        }else if(calculator.getSquare(first)<calculator.getSquare(second)){
            return -1;
        }
        return 0;
    }
}
