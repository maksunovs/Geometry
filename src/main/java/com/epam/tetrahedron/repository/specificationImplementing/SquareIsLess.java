package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;
import com.epam.tetrahedron.repository.comparatorImplementing.ComparasionByCoordinateX;
import org.apache.log4j.Logger;

public class SquareIsLess implements Specification<Tetrahedron> {
    private final double rightBorder;
    private final Logger log = Logger.getLogger(SquareIsLess.class);
    public SquareIsLess(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    @Override
    public boolean specified(Tetrahedron obj) {
        if(obj == null ){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        return false;
    }
}
