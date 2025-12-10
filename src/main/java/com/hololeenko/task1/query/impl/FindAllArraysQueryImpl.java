package com.hololeenko.task1.query.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.query.Query;

public class FindAllArraysQueryImpl implements Query {
    @Override
    public boolean matches(CustomArray customArray) {
        return true;
    }
}
