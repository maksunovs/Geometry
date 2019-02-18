package com.epam.tetrahedron.creation.director;

import com.epam.tetrahedron.action.FigureConfirm;
import com.epam.tetrahedron.creation.parsing.DataParser;
import com.epam.tetrahedron.creation.reading.DataReader;
import com.epam.tetrahedron.creation.validation.DataValidator;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.GeometryExceptions;
import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;


public class DirectorTest {

    private final DataReader dataReader = Mockito.mock(DataReader.class);
    private final DataValidator dataValidator = Mockito.mock(DataValidator.class);
    private final DataParser dataParser = Mockito.mock(DataParser.class);
    private final FigureConfirm figureConfirm = Mockito.mock(FigureConfirm.class);
    private final Director director = new Director(dataReader,dataValidator,dataParser,figureConfirm);
    private final Point point1 = new Point(12.0,0.0,34.0);
    private final Point point2 = new Point(34.0, 0.0, 54.0);
    private final double lengthIsTwelve=12.0;
    private final double lengthIsSixtyFive=65.0;
    @Test
    public void shouldCreateTetrahedronWhenCorrectData() throws GeometryExceptions {
        when(dataReader.readDataFromFile(anyString())).thenReturn(Arrays.asList("12.0 0.0 34.0 12.0","34.0 0.0 54.0 65.0"));
        when(dataValidator.isValid(anyString())).thenReturn(true).thenReturn(true);
        when(dataParser.getDoubleData(anyString())).thenReturn(new Double[] {12.0,0.0, 34.0,12.0}).thenReturn(new Double[]{34.0,0.0,54.0,65.0});
        when(figureConfirm.isTetrahedron(anyDouble())).thenReturn(true).thenReturn(true);
        Assert.assertEquals(Arrays.asList(new Tetrahedron(point1,lengthIsTwelve),new Tetrahedron(point2,lengthIsSixtyFive)),director.createFrom("Test.txt"));
        verify(dataReader).readDataFromFile(anyString());
        verify(dataValidator,atLeast(2)).isValid(anyString());
        verify(dataParser,atLeast(2)).getDoubleData(anyString());
        verify(figureConfirm,atLeast(2)).isTetrahedron(anyDouble());
        verifyNoMoreInteractions(dataReader,dataValidator,dataParser,figureConfirm);
    }
}