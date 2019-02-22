package com.epam.tetrahedron.creation.identification;

public class IdGenerator {
    private static int counter=1;
    public static int generateId() {
        return counter++;
    }
}
