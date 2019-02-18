package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.NotAcrossFigureException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
   private final Calculator calculator = new Calculator();
   private final  Point point = new Point(0.0,0.0,0.0);
    @Test
    public void shouldCalculateSquare (){
        //given
        double edgeLength = 5.0;
        Tetrahedron tetrahedron = new Tetrahedron(point,edgeLength);
        //when
        double result = calculator.getSquare(tetrahedron);
        //then
        double expected = 64.9519;
        Assert.assertEquals(expected,result,0.001);
    }

    @Test
    public void shouldCalculateVolume(){
        double edgeLength = 10.0;
        Tetrahedron tetrahedron = new Tetrahedron(point,edgeLength);
        double result = calculator.getVolume(tetrahedron);
        double expected = 117.8511;
        Assert.assertEquals(expected,result,0.001);
    }

    @Test
    public void shouldCalculateVolumeRatio() throws NotAcrossFigureException {
        double edgeLength = 1.22479;
        Point point = new Point(0.0,0.0, -0.21);
        Tetrahedron tetrahedron = new Tetrahedron(point, edgeLength);
        double result = calculator.getVolumeRatio(tetrahedron);
        double expected = 1.0;
        Assert.assertEquals(expected,result,0.03);
    }
//
}