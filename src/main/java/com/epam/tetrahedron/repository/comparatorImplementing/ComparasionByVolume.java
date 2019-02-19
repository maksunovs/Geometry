package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;
import org.apache.log4j.Logger;

public class ComparasionByVolume implements Comparator<Tetrahedron> {
    private final Logger log = Logger.getLogger(ComparasionByVolume.class);
    private final Calculator calculator;

    public ComparasionByVolume(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first==null||second==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        if(calculator.getVolume(first)>calculator.getVolume(second)) {
            return 1;
        }else if(calculator.getVolume(first)<calculator.getVolume(second)){
            return -1;
        }
        return 0;
    }
}
