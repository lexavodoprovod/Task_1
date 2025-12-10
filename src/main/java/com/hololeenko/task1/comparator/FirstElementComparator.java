package com.hololeenko.task1.comparator;

import com.hololeenko.task1.entity.CustomArray;

import java.util.Arrays;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray array1, CustomArray array2) {

        int firstElementArray1 = array1.getFirstElementOfArray();
        int firstElementArray2 = array2.getFirstElementOfArray();

        return Integer.compare(firstElementArray1, firstElementArray2);
    }
}
