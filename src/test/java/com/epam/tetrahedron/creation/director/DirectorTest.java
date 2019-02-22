package com.epam.tetrahedron.creation.director;

import com.epam.tetrahedron.action.FigureConfirm;
import com.epam.tetrahedron.creation.identification.IdGenerator;
import com.epam.tetrahedron.creation.parsing.DataParser;
import com.epam.tetrahedron.creation.reading.DataReader;
import com.epam.tetrahedron.creation.validation.DataValidator;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.GeometryExceptions;
import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class DirectorTest {

    private final DataReader dataReader = Mockito.mock(DataReader.class);
    private final DataValidator dataValidator = Mockito.mock(DataValidator.class);
    private final DataParser dataParser = Mockito.mock(DataParser.class);
    private final FigureConfirm figureConfirm = Mockito.mock(FigureConfirm.class);
    private final Director director = new Director(dataReader,dataValidator,dataParser,figureConfirm);
    private static final Point FIRST_POINT = new Point(12.0,0.0,34.0);
    private static final Point SECOND_POINT = new Point(34.0, 0.0, 54.0);
    private static  final double LENGTH_IS_TWELVE=12.0;
    private static final double LENGTH_IS_SIXTY_FIVE=65.0;
    private static final String FILE_NAME = "Test.txt";
    private static final String FIRST_STRING_DATA = "12.0 0.0 34.0 12.0";
    private  static  final String SECOND_STRING_DATA = "34.0 0.0 54.0 65.0";
    @Test
    public void shouldCreateTetrahedronWhenCorrectData() throws GeometryExceptions {
        when(dataReader.readDataFromFile(anyString())).thenReturn(Arrays.asList(FIRST_STRING_DATA,SECOND_STRING_DATA));
        when(dataValidator.isValid(anyString())).thenReturn(true).thenReturn(true);
        when(dataParser.getDoubleData(anyString())).thenReturn(new Double[] {12.0,0.0, 34.0,12.0}).thenReturn(new Double[]{34.0,0.0,54.0,65.0});
        when(figureConfirm.isTetrahedron(anyDouble())).thenReturn(true).thenReturn(true);
        List<Tetrahedron> expected =  Arrays.asList(new Tetrahedron(FIRST_POINT,LENGTH_IS_TWELVE),new Tetrahedron(SECOND_POINT,LENGTH_IS_SIXTY_FIVE));
        expected.get(0).setId(3);
        expected.get(1).setId(4);
        Assert.assertEquals(expected,director.createFrom(FILE_NAME));
        verify(dataReader).readDataFromFile(anyString());
        verify(dataValidator,atLeast(2)).isValid(anyString());
        verify(dataParser,atLeast(2)).getDoubleData(anyString());
        verify(figureConfirm,atLeast(2)).isTetrahedron(anyDouble());
        verifyNoMoreInteractions(dataReader,dataValidator,dataParser,figureConfirm);
    }
}