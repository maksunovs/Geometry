package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;
import org.apache.log4j.Logger;

public class ComparasionBySquare implements Comparator<Tetrahedron> {
    private final Logger log = Logger.getLogger(ComparasionBySquare.class);
    private final Calculator calculator;

    public ComparasionBySquare(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first==null||second==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        if(calculator.getSquare(first)>calculator.getSquare(second)) {
            return 1;
        }else if(calculator.getSquare(first)<calculator.getSquare(second)){
            return -1;
        }
        return 0;
    }
}
