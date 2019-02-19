package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;
import com.epam.tetrahedron.repository.comparatorImplementing.ComparasionByCoordinateX;
import org.apache.log4j.Logger;

public class PointInThirdSquare implements Specification<Tetrahedron> {
    private final int requirement;
    private final Logger log = Logger.getLogger(PointInThirdSquare.class);
    public PointInThirdSquare(int requirement) {
        this.requirement = requirement;
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