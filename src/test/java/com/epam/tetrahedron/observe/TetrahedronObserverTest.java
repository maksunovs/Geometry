package com.epam.tetrahedron.observe;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.TetrahedronParameters;
import org.junit.Assert;
import org.junit.Test;



public class TetrahedronObserverTest {
    private static  final Point POINT = new Point(12.0,34.0,56.0);
    private static final double LENGTH_IS_TEN = 10;
    private final TetrahedronObservable tetrahedronObservable = new TetrahedronObservable(POINT,LENGTH_IS_TEN);
    private static final TetrahedronObserver OBSERVER = TetrahedronObserver.getInstance();
    @Test
    public void shouldUpdateParametersWhenTheyChange() {
        tetrahedronObservable.setEdgeLength(34.0);
        OBSERVER.update(tetrahedronObservable);
        TetrahedronParameters parameters = OBSERVER.getParameters(tetrahedronObservable.getId());
        double expectedVolume = 4632.02;
        double expectedSquare = 3003.376;
        Assert.assertNotNull(parameters);
        Assert.assertEquals(expectedVolume,parameters.getVolume(),0.001);
        Assert.assertEquals(expectedSquare,parameters.getSquare(),0.001);
    }

    @Test
    public void shouldReturnCorrectParametersFromRegistryClass() {
        TetrahedronParameters parameters = OBSERVER.getParameters(tetrahedronObservable.getId());
        double expectedVolume = 117.8511;
        double expectedSquare = 259.807;
        Assert.assertNotNull(parameters);
        Assert.assertEquals(expectedVolume,parameters.getVolume(),0.001);
        Assert.assertEquals(expectedSquare,parameters.getSquare(),0.001);
    }
}