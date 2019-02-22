package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.NotAcrossFigureException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
   private final Calculator calculator = new Calculator();
   private final  Point point = new Point(0.0,0.0,0.0);
   private  static  final double LENGTH_IS_TEN = 10.0;
   //private  static  final double
    @Test
    public void shouldCalculateSquare (){
        Tetrahedron tetrahedron = new Tetrahedron(point,LENGTH_IS_TEN);
        //when
        double result = calculator.getSquare(tetrahedron);
        //then
        double expected = 259.807;
        Assert.assertEquals(expected,result,0.001);
    }

    @Test
    public void shouldCalculateVolume(){
        Tetrahedron tetrahedron = new Tetrahedron(point,LENGTH_IS_TEN);
        double result = calculator.getVolume(tetrahedron);
        double expected = 117.8511;
        Assert.assertEquals(expected,result,0.001);
    }

    @Test
    public void shouldCalculateVolumeRatio() throws NotAcrossFigureException {
        Point point = new Point(0.0,0.0, -0.21);
        Tetrahedron tetrahedron = new Tetrahedron(point, LENGTH_IS_TEN);
        double result = calculator.getVolumeRatio(tetrahedron);
        double expected = 0.0813;
        Assert.assertEquals(expected,result,0.03);
    }
//
}