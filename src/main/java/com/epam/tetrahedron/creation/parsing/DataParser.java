package com.epam.tetrahedron.creation.parsing;


import org.apache.log4j.Logger;

public class DataParser {
   private final int numberOfElements=4;
   private final String separator = " ";
   public Double[] getDoubleData(String dataInput){

     Double[] doubleData = new Double[numberOfElements];

        String[] stringData = dataInput.split(separator);
        for(int i=0; i<doubleData.length; i++) {
            doubleData[i]=Double.parseDouble(stringData[i]);
        }

        return doubleData;
    }
}
