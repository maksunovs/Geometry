package com.epam.tetrahedron.repository;
import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.comparatorImplementing.ComparisonByID;
import com.epam.tetrahedron.repository.comparatorImplementing.ComparisonByVolume;
import com.epam.tetrahedron.repository.specificationImplementing.EdgeLengthIsMore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TetrahedronRepositoryTest {
    private static final Point POINT = new Point(0.0, 0.0, 0.0);
    private static final double LENGTH_IS_TEN = 10.0;
    private static final double LENGTH_IS_FIVE = 5;
    private static final double LENGTH_IS_TWELVE = 12;
    private static final double LENGTH_IS_SEVEN = 7;
    private static final Tetrahedron FIRST = new Tetrahedron(POINT,LENGTH_IS_FIVE);
    private static final Tetrahedron SECOND = new Tetrahedron(POINT,LENGTH_IS_SEVEN);
    private static final Tetrahedron THIRD = new Tetrahedron(POINT,LENGTH_IS_TEN);
    private static final Tetrahedron FOURTH = new Tetrahedron(POINT, LENGTH_IS_TWELVE);
    private final TetrahedronRepository repository = new TetrahedronRepository();
    private  final Specification<Tetrahedron> lengthIsMore = new EdgeLengthIsMore(LENGTH_IS_FIVE);
    private final Comparator<Tetrahedron> compareByVolume = new ComparisonByVolume(new Calculator());
    private final Comparator<Tetrahedron> compareByID = new ComparisonByID();
    @Before
    public void initializeRepository(){
        repository.add(SECOND);
        repository.add(FIRST);
        repository.add(FOURTH);
        repository.add(THIRD);
    }
    @Test
    public void shouldReturnSizeFourWhenAddFourObjects() {
        int expected=4;
        Assert.assertEquals(expected,repository.size());

    }
    @Test
    public void shouldReturnSizeThreeWhenRemoveOneObject(){
        repository.remove(FIRST.getId());
        int expected =3;
        Assert.assertEquals(expected,repository.size());
    }
    @Test
    public void shouldReturnObjectsWhichEdgeLengthIsMoreThanFive(){
        List<Tetrahedron> actualLIst = repository.query(lengthIsMore);
        List<Tetrahedron> expectedList = Arrays.asList(SECOND,FOURTH,THIRD);
        Assert.assertEquals(expectedList,actualLIst);
    }
    @Test
    public void shouldSortRepositoryByVolume(){
        List<Tetrahedron> expectedList = Arrays.asList(FIRST,SECOND,THIRD,FOURTH);
        repository.sort(compareByVolume);
        List<Tetrahedron> actualList = repository.getAll();
        Assert.assertEquals(expectedList,actualList);
    }
    @Test
    public void shouldSortRepositoryByID(){
        List<Tetrahedron> expectedList = Arrays.asList(FIRST,SECOND,THIRD,FOURTH);
        repository.sort(compareByID);
        List<Tetrahedron> actualList = repository.getAll();
        Assert.assertEquals(expectedList,actualList);
    }
    @Test
    public void shouldUpdateRepositoryWhenFirstObjectChanged(){
        FIRST.setEdgeLength(LENGTH_IS_TWELVE);
        repository.update(FIRST);
        List<Tetrahedron> expectedList = Arrays.asList(SECOND,FIRST,FOURTH,THIRD);
        List<Tetrahedron> actualList = repository.getAll();
        Assert.assertEquals(expectedList,actualList);
        FIRST.setEdgeLength(LENGTH_IS_FIVE);
    }
}
