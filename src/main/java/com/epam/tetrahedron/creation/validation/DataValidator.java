package com.epam.tetrahedron.creation.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private static  final String FORMAT_LINE = "^\\s*(-|\\+)?\\d+\\.?\\d*\\s+(-|\\+)?\\d+\\.?\\d*\\s+(-|\\+)?\\d+\\.?\\d*\\s+\\+?\\d+\\.?\\d*\\s*?$";

    public boolean isValid(String data){
        Pattern p = Pattern.compile(FORMAT_LINE);
        Matcher m = p.matcher(data);
        return m.matches();
    }

}
