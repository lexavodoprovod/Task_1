package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.validation.IDValidation;

import java.util.List;

public class FindByIDQueryImpl implements Query {

    private int expectedID;

    public FindByIDQueryImpl(int expectedID){
        this.expectedID = expectedID;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        return customArray.getId() == expectedID;
    }
}
