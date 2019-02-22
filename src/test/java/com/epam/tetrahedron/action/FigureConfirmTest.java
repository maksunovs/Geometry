package com.epam.tetrahedron.action;


import org.junit.Assert;
import org.junit.Test;


public class FigureConfirmTest {
    private static final double ZERO_LENGTH= 0.0;
    private static final double NON_ZERO_LENGTH = 10.0;
    private final FigureConfirm figureConfirm = new FigureConfirm();

    @Test
    public void isTetrahedronWhenZeroLength() {
        boolean result =figureConfirm.isTetrahedron(ZERO_LENGTH);
        Assert.assertFalse(result);
    }

    @Test
    public void isTetrahedronWhenNonZeroLength() {
        boolean result =figureConfirm.isTetrahedron(NON_ZERO_LENGTH);
        Assert.assertTrue(result);
    }
}