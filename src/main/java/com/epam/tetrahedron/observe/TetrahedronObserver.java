package com.epam.tetrahedron.observe;

import com.epam.tetrahedron.action.Calculator;
import com.epam.tetrahedron.entity.TetrahedronParameters;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserver implements Observer<TetrahedronObservable> {
    private static TetrahedronObserver INSTANCE = null;
    private Map<Integer, TetrahedronParameters> tetrahedronParametersMap = new HashMap<>();
    private  Calculator calculator = new Calculator();

    private TetrahedronObserver() {
    }

    public static  TetrahedronObserver getInstance(){
        if(INSTANCE==null) {
            INSTANCE = new TetrahedronObserver();
        }
        return INSTANCE;
    }

    @Override
    public void update(TetrahedronObservable tetrahedronObservable) {
            TetrahedronParameters parameters = new TetrahedronParameters(calculator.getSquare(tetrahedronObservable),calculator.getVolume(tetrahedronObservable));
            tetrahedronParametersMap.put(tetrahedronObservable.getId(),parameters);
    }

    public TetrahedronParameters getParameters(int id){
        return tetrahedronParametersMap.get(id);
    }
}
