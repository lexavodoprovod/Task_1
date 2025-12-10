package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;

import java.util.OptionalInt;

public class FIndArraysWithBiggerMinValueQueryImpl implements Query {
    private int value;

    public FIndArraysWithBiggerMinValueQueryImpl(int value) {
        this.value = value;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        CalculationService service = new CalculationServiceImpl();

        OptionalInt min = service.findMin(customArray.getArray());
        int minValue = min.orElse(0);

        return minValue>value;
    }
}
