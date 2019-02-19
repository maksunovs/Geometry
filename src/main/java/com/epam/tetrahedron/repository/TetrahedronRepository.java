package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;
import org.apache.log4j.Logger;

import java.util.*;

public class TetrahedronRepository implements Repository<Tetrahedron> {
    private final Map<Integer,Tetrahedron> repository = new HashMap<>();
    private final Logger log = Logger.getLogger(TetrahedronRepository.class);
    @Override
    public void add(Tetrahedron obj) {
        if(obj==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        repository.put(obj.getId(),obj);
    }

    @Override
    public void add(Collection<Tetrahedron> t) {
        if(t==null) {
            log.error("Null pointer[add(Collection<Tetrahedron> t)]");
            throw new NullPointerException("Null pointer");
        }
        for(Tetrahedron obj: t){
                repository.put(obj.getId(),obj);
        }
    }


    @Override
    public void update(Tetrahedron obj) {
        if(obj==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        if(repository.containsKey(obj.getId())) {
            repository.put(obj.getId(),obj);
        }else{
            log.error("Object is not in list");
        }
    }
    @Override
    public void remove(Tetrahedron obj) {
        if(obj==null){
            log.error("Null pointer");
            throw new NullPointerException("Null pointer");
        }
        if(repository.containsKey(obj.getId())) {
            repository.remove(obj.getId());
        }else{
            log.error("Object is not in list");
        }

    }
    @Override
    public void remove(Specification specification) {
        for(Tetrahedron obj:repository.values()){
            if(specification.specified(obj)){
                repository.remove(obj.getId());
            }
        }
    }

    @Override
    public List<Tetrahedron> query(Specification specification) {
        List<Tetrahedron> list = new ArrayList<>();
        for(Tetrahedron obj: repository.values()){
                if(specification.specified(obj)){
                    list.add(obj);
                }
        }
        return list;
    }

    @Override
    public List<Tetrahedron> sort(Comparator comparator) {
        Tetrahedron temp;
        List<Tetrahedron> list = new ArrayList<>(repository.values());
        for(int i=0; i<list.size();i++){
            for(int j=i+1; j<list.size(); j++){
                if(comparator.compare(list.get(i),list.get(j))>0){
                    temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return list;
    }
}
