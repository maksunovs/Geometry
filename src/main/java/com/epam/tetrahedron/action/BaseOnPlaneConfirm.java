package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;

public class BaseOnPlaneConfirm {
    public boolean isBaseOnXOYPlane(Tetrahedron tetrahedron){
        Point point = tetrahedron.getPoint();
        double z = point.getZ();
        return z == 0;
    }
}
