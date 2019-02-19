package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;
import org.apache.log4j.Logger;

public class ComparasionByCoordinateY implements Comparator<Tetrahedron> {
    private final Logger log = Logger.getLogger(ComparasionByCoordinateY.class);
    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first==null||second==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        if(first.getPoint().getY()>second.getPoint().getY()) {
            return 1;
        }else if(first.getPoint().getY()<second.getPoint().getY()){
            return -1;
        }
        return 0;
    }

}
