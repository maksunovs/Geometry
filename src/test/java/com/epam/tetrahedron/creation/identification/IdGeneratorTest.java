package com.epam.tetrahedron.creation.identification;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdGeneratorTest {
    private int id;
    @Test
    public void shouldGenerateOneTwoThree() {
        id=IdGenerator.generateId();
        Assert.assertEquals(1,id);
        id=IdGenerator.generateId();
        Assert.assertEquals(2,id);
        id=IdGenerator.generateId();
        Assert.assertEquals(3,id);
    }
}