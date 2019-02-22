package com.epam.tetrahedron.creation.parsing;

import org.junit.Assert;
import org.junit.Test;

public class DataParserTest {
    private final DataParser parser = new DataParser();
    private  static  final String STRING_DATA = "12.0 -12.0 +34.0 10     ";
    @Test
    public void shouldConvertStringToDouble() {
        Double[] doubleData = parser.getDoubleData(STRING_DATA);
        Double[] expected = {12.0, -12.0, 34.0, 10.0};
        Assert.assertArrayEquals(expected,doubleData);

    }
}