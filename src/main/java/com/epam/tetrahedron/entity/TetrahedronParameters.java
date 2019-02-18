package com.epam.tetrahedron.entity;

public class TetrahedronParameters {

    private final double square;
    private final double volume;

    public TetrahedronParameters(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

public double getSquare(){
        return square;
}
public double getVolume(){
        return volume;
}
}
