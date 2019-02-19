package com.epam.tetrahedron.repository.comparatorImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Comparator;
import org.apache.log4j.Logger;

public class ComparasionByCoordinateZ implements Comparator<Tetrahedron> {
    private final Logger log = Logger.getLogger(ComparasionByCoordinateZ.class);
    @Override
    public int compare(Tetrahedron first, Tetrahedron second) {
        if(first==null||second==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        if(first.getPoint().getZ()>second.getPoint().getZ()) {
            return 1;
        }else if(first.getPoint().getZ()<second.getPoint().getZ()){
            return -1;
        }
        return 0;
    }
}
