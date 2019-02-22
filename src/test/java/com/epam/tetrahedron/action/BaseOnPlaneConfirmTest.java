package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class BaseOnPlaneConfirmTest {
 private  final  BaseOnPlaneConfirm  baseOnPlaneConfirm = new BaseOnPlaneConfirm();
 private static final double LENGTH_IS_FIVE = 5.0;
    @Test
    public void shouldTrueWhenBaseOnPlane() {
        Point point = new Point(0.0,0.0,0.0);
        Tetrahedron tetrahedron = new Tetrahedron(point, LENGTH_IS_FIVE);
        boolean result = baseOnPlaneConfirm.isBaseOnXOYPlane(tetrahedron);
        Assert.assertTrue(result);
    }
    @Test
    public void shouldFalseWhenBaseNotOnPlane(){
        Point point = new Point(0.0,0.0,6.0);
        Tetrahedron tetrahedron = new Tetrahedron(point, LENGTH_IS_FIVE);
        boolean result = baseOnPlaneConfirm.isBaseOnXOYPlane(tetrahedron);
        Assert.assertFalse(result);
    }
}