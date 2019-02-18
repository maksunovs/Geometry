package com.epam.tetrahedron.creation.parsing;

import org.junit.Assert;
import org.junit.Test;

public class DataParserTest {
    private final DataParser parser = new DataParser();
    @Test
    public void shouldConvertStringToDouble() {
        String stringData="12.0 -12.0 +34.0 10     ";
        Double[] doubleData = parser.getDoubleData(stringData);
        Double[] expected = {12.0, -12.0, 34.0, 10.0};
        Assert.assertArrayEquals(expected,doubleData);

    }
}