package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;

import java.util.OptionalInt;

public class FIndArraysWithBiggerMaxValueQueryImpl implements Query {
    private int value;

    public FIndArraysWithBiggerMaxValueQueryImpl(int value) {
        this.value = value;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        CalculationService service = new CalculationServiceImpl();

        OptionalInt max = service.findMax(customArray.getArray());
        int maxValue = max.orElse(0);

        return maxValue>value;
    }
}
