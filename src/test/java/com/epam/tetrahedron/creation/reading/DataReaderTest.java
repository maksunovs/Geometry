package com.epam.tetrahedron.creation.reading;

import com.epam.tetrahedron.exception.GeometryExceptions;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;

public class DataReaderTest {
    private final DataReader dataReader = new DataReader();
    private static final String FILE_NAME = "Test.txt";
    private static final String FIRST_STRING_DATA = "12.0 0.0 34.0 12.0";
    private  static  final String SECOND_STRING_DATA = "34.0 0.0 54.0 65.0";
    @Test
    public void shouldReadFileToString() throws GeometryExceptions {
        List<String>result = dataReader.readDataFromFile(FILE_NAME);
        List<String> expected = new ArrayList<>(Arrays.asList(FIRST_STRING_DATA,SECOND_STRING_DATA));
        Assert.assertEquals(expected,result);
    }
}