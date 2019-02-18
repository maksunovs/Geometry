package com.epam.tetrahedron.observe;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.TetrahedronParameters;
import org.junit.Assert;
import org.junit.Test;



public class TetrahedronObserverTest {
    private final Point point = new Point(12.0,34.0,56.0);
    private final double edgeLength = 10;
    private final TetrahedronObservable tetrahedronObservable = new TetrahedronObservable(point,edgeLength);
    private final TetrahedronObserver observer = TetrahedronObserver.getInstance();
    @Test
    public void shouldUpdateParametersWhenTheyChange() {
        tetrahedronObservable.setEdgeLength(34.0);
        observer.update(tetrahedronObservable);
        TetrahedronParameters parameters = observer.getParameters(tetrahedronObservable.getId());
        double expectedVolume = 4632.02;
        double expectedSquare = 3003.376;
        Assert.assertNotNull(parameters);
        Assert.assertEquals(expectedVolume,parameters.getVolume(),0.001);
        Assert.assertEquals(expectedSquare,parameters.getSquare(),0.001);
    }

    @Test
    public void shouldReturnCorrectParametersFromRegistryClass() {
        TetrahedronParameters parameters = observer.getParameters(tetrahedronObservable.getId());
        double expectedVolume = 117.8511;
        double expectedSquare = 259.807;
        Assert.assertNotNull(parameters);
        Assert.assertEquals(expectedVolume,parameters.getVolume(),0.001);
        Assert.assertEquals(expectedSquare,parameters.getSquare(),0.001);
    }
}