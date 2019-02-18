package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import  com.epam.tetrahedron.exception.NotAcrossFigureException;

public class Calculator {
    public double getSquare(Tetrahedron tetrahedron)  {
        return Math.pow(tetrahedron.getEdgeLength(),2.0)*Math.sqrt(3.0)*3/2;
    }

    public double getVolume(Tetrahedron tetrahedron){
        return Math.pow(tetrahedron.getEdgeLength(),3.0)*Math.sqrt(2.0)/12;
    }

    public double getVolumeRatio(Tetrahedron tetrahedron) throws NotAcrossFigureException{
        Point point = tetrahedron.getPoint();
        double zOfBase = point.getZ();
        double height = tetrahedron.getEdgeLength()*Math.sqrt(6.0)/3.0;
        double zOfTop = zOfBase + height;
        double zOfAcrossPoint = 0;
        if(zOfAcrossPoint<=zOfBase||zOfAcrossPoint>=zOfTop){
            throw  new NotAcrossFigureException("plane does't across figure");
        }
        return Math.pow((zOfTop-zOfBase)/(zOfTop-zOfAcrossPoint),3.0)-1;
    }


}
