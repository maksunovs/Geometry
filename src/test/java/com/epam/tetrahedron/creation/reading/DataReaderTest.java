package com.epam.tetrahedron.creation.reading;

import com.epam.tetrahedron.exception.GeometryExceptions;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;

public class DataReaderTest {
    private final DataReader dataReader = new DataReader();
    @Test
    public void shouldReadFileToString() throws GeometryExceptions {
        List<String>result = dataReader.readDataFromFile("Tes.txt");
        for (String s : result) System.out.println(s);
        List<String> expected = new ArrayList<>(Arrays.asList("12.0 0.0 34.0 12.0","34.0 0.0 54.0 65.0"));
        Assert.assertEquals(expected,result);
    }
}