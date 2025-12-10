package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;

public class FIndArraysWithBiggerAvgQueryImpl implements Query {
    private int value;

    public FIndArraysWithBiggerAvgQueryImpl(int value) {
        this.value = value;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        CalculationService service = new CalculationServiceImpl();

        int avg = service.calculateAverage(customArray.getArray());

        return avg>value;
    }
}
