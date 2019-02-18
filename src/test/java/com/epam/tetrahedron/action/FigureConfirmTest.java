package com.epam.tetrahedron.action;


import org.junit.Assert;
import org.junit.Test;


public class FigureConfirmTest {
    private final double lengthIsZero = 0.0;
    private final double lengthIsTen = 10.0;
    private final FigureConfirm figureConfirm = new FigureConfirm();

    @Test
    public void isTetrahedronWhenZeroLength() {
        boolean result =figureConfirm.isTetrahedron(lengthIsZero);
        Assert.assertFalse(result);
    }

    @Test
    public void isTetrahedronWhenNonZeroLength() {
        boolean result =figureConfirm.isTetrahedron(lengthIsTen);
        Assert.assertTrue(result);
    }
}