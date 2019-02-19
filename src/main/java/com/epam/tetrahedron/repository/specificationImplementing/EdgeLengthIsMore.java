package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;
import com.epam.tetrahedron.repository.comparatorImplementing.ComparasionByCoordinateX;
import org.apache.log4j.Logger;

public class EdgeLengthIsMore implements Specification<Tetrahedron> {
    private final double leftBorder;
    private final Logger log = Logger.getLogger(EdgeLengthIsMore.class);
    public EdgeLengthIsMore(double leftBorder) {
        this.leftBorder = leftBorder;
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
