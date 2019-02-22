package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.TetrahedronRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecificationTest {
    private static final Point POINT = new Point(0.0, 0.0, 0.0);
    private final double lengthIsTen = 10.0;
    private final double lengthIsFive = 5;
    private final Tetrahedron firstObject = new Tetrahedron(POINT,lengthIsTen);
    private final Tetrahedron secondObject = new Tetrahedron(POINT,lengthIsFive);
    private final TetrahedronRepository repository = new TetrahedronRepository();

    @Test
    public void shouldReturnSizeTwoWhenAddTwoObjects() {
        repository.add(firstObject);
        repository.add(secondObject);
        int expected=2;
        Assert.assertEquals(expected,repository.size());

    }
}