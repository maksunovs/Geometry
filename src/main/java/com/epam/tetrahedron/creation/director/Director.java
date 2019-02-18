package com.epam.tetrahedron.creation.director;

import com.epam.tetrahedron.action.FigureConfirm;
import com.epam.tetrahedron.creation.parsing.DataParser;
import com.epam.tetrahedron.creation.reading.DataReader;
import com.epam.tetrahedron.creation.validation.DataValidator;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.FileNotExistException;
import com.epam.tetrahedron.exception.ReadDataErrorException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Director {
    private final DataReader dataReader;
    private final DataValidator dataValidator;
    private final DataParser dataParser;
    private final FigureConfirm figureConfirm;
    private final int xLocation=0;
    private final int yLocation=1;
    private final int zLocation = 2;
    private final int edgeLength = 3;
    private final Logger log = Logger.getLogger(Director.class);

    public Director(DataReader dataReader, DataValidator dataValidator, DataParser dataParser, FigureConfirm figureConfirm){
        this.dataReader=dataReader;
        this.dataValidator=dataValidator;
        this.dataParser=dataParser;
        this.figureConfirm=figureConfirm;
    }

    public List<Tetrahedron> createFrom(String name){
        List<String> stringData = null;
        try {
            stringData= dataReader.readDataFromFile(name);
        }catch(FileNotExistException| ReadDataErrorException err){
            log.error(err.getMessage());
        }
        List<Double[]> doubleData = new ArrayList<>();
        List<Tetrahedron> list = new ArrayList<>();
        Point point;
        try{
            for(String string: stringData) {
                if (dataValidator.isValid(string)) {
                    doubleData.add(dataParser.getDoubleData(string));
                }
            }
        }catch (NullPointerException err){
            log.error(err.getMessage());
        }
        for(Double[] data: doubleData){
            if(!figureConfirm.isTetrahedron(data[edgeLength])) {
                continue;
            }
           point = new Point(data[xLocation],data[yLocation],data[zLocation]);
           list.add(new Tetrahedron(point,data[edgeLength]));

        }
        return  list;
    }
}
