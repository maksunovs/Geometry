package com.epam.tetrahedron.exception;

public class GeometryExceptions extends Exception {
    private String message;
    GeometryExceptions(String message){
        this.message=message;
    }
    public String getMessage()
    {
        return message;
    }
}
