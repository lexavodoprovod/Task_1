package com.hololeenko.task1.comparator;

import com.hololeenko.task1.entity.CustomArray;

import java.util.Comparator;

public class LengthComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray array1, CustomArray array2) {
        int array1Length = array1.getLength();
        int array2Length = array2.getLength();
        return Integer.compare(array1Length, array2Length);
    }
}
