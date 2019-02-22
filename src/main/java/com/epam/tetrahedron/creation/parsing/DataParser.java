package com.epam.tetrahedron.creation.parsing;



public class DataParser {
   private static final int NUMBER_OF_ELEMENTS=4;
   private static final String SEPARATOR = " ";
   public Double[] getDoubleData(String dataInput){

     Double[] doubleData = new Double[NUMBER_OF_ELEMENTS];

        String[] stringData = dataInput.split(SEPARATOR);
        for(int i=0; i<doubleData.length; i++) {
            doubleData[i]=Double.parseDouble(stringData[i]);
        }

        return doubleData;
    }
}
