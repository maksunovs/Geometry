package com.epam.tetrahedron.repository.specificationImplementing;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.Specification;

public class SpecificationByID implements Specification<Tetrahedron> {
    private final int id;
    public SpecificationByID(int id){
        this.id=id;
    }
    @Override
    public boolean specified(Tetrahedron obj) {
        return obj.getId()==id;
    }
}
