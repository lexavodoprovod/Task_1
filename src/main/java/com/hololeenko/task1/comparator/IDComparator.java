package com.hololeenko.task1.comparator;

import com.hololeenko.task1.entity.CustomArray;

import java.util.Comparator;

public class IDComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray array1, CustomArray array2) {
        return Long.compare(array1.getId(), array2.getId());
    }
}
