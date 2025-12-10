package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;

import java.util.OptionalInt;

public class FindArraysWithBiggerLengthQueryImpl implements Query {
    private int value;

    public FindArraysWithBiggerLengthQueryImpl(int value) {
        this.value = value;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        return customArray.getLength() >value;
    }
}
