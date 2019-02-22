package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;
import org.apache.log4j.Logger;

import java.util.*;

public class TetrahedronRepository implements Repository<Tetrahedron> {
    private final List<Tetrahedron> repository = new ArrayList<>();
    private final Logger log = Logger.getLogger(TetrahedronRepository.class);
    @Override
    public void add(Tetrahedron obj) {
        if(obj==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        for(Tetrahedron temp: repository) {
            if (temp.getId() == obj.getId()) {
                repository.set(repository.indexOf(temp), obj);
                return;
            }
        }
        repository.add(obj);

    }

    @Override
    public void add(Collection<Tetrahedron> t) {
        if(t==null) {
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        for(Tetrahedron obj: t){
            boolean flag=false;
            for(Tetrahedron temp: repository){
                if (temp.getId() == obj.getId()) {
                    repository.set(repository.indexOf(temp), obj);
                    flag=true;
                }
            }
            if(!flag){
                repository.add(obj);
            }
        }
    }


    @Override
    public void update(Tetrahedron obj) {
        if(obj==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        for(Tetrahedron temp: repository) {
            if (temp.getId() == obj.getId()) {
                repository.set(repository.indexOf(temp),obj);
                return;
            }
        }
        log.info("Object is not in repository");
    }
    @Override
    public void remove(int tetrahedronID) {
        for(Tetrahedron temp: repository){
            if(temp.getId()==tetrahedronID){
                repository.remove(temp);
                return;
            }
        }
        log.info("Object does not exist in repository");
    }
    @Override
    public void remove(Specification<Tetrahedron> specification) {
        for(Tetrahedron temp: repository){
            if(specification.specified(temp)){
                repository.remove(temp);
            }
        }
    }

    @Override
    public List<Tetrahedron> query(Specification<Tetrahedron> specification) {
        List<Tetrahedron> list = new ArrayList<>();
        for(Tetrahedron temp: repository){
                if(specification.specified(temp)){
                    list.add(temp);
                }
        }
        return list;
    }

    @Override
    public void sort(Comparator<Tetrahedron> comparator) {
        Tetrahedron temp;
        for(int i=0; i<repository.size();i++){
            for(int j=i+1; j<repository.size(); j++){
                if(comparator.compare(repository.get(i),repository.get(j))>0){
                    temp=repository.get(i);
                    repository.set(i,repository.get(j));
                    repository.set(j,temp);
                }
            }
        }
    }
    public int size(){
        return  repository.size();
    }
}
