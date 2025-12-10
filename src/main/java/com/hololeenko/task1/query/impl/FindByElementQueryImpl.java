package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FindByElementQueryImpl implements Query {

    private final List<Integer> elementsofArray = new ArrayList<>();

    public FindByElementQueryImpl(int ... elements) {
        for(int element : elements){
            this.elementsofArray.add(element);
        }
    }

    @Override
    public boolean matches(CustomArray customArray) {

        if(elementsofArray.isEmpty()){
            return false;
        }
        List<Integer> numOfContainElements = new ArrayList<>();

        int[] array = customArray.getArray();
        for(int element : array){
            if(elementsofArray.contains(element)){
               numOfContainElements.add(element);
            }
        }
        return numOfContainElements.size() == elementsofArray.size();
    }
}
