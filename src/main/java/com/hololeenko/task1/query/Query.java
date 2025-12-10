package com.hololeenko.task1.query;

import com.hololeenko.task1.entity.CustomArray;

import java.util.List;

public interface Query {
    boolean matches(CustomArray customArray);
}
