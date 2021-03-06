package com.epam.tetrahedron.observe;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;


public class TetrahedronObservable extends Tetrahedron implements Observable<TetrahedronObservable>{
   private static final TetrahedronObserver OBSERVER = TetrahedronObserver.getInstance();
    public TetrahedronObservable(Point point, double edgeLength)
    {
        super(point, edgeLength);
        OBSERVER.update(this);
    }

    @Override
    public void setEdgeLength(double edgeLength) {
        super.setEdgeLength(edgeLength);
        notifyObserver();
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
    OBSERVER.update(this);
    }
}
