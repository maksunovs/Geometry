package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;

public class BaseOnPlaneConfirm {
    //лежит ли основание на одной из плоскостей, а именно  на  плоскости XOY
    public boolean isBaseOnXOYPlane(Tetrahedron tetrahedron){
        Point point = tetrahedron.getPoint();
        double z = point.getZ();
        return z == 0;
    }
}
