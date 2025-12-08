package com.hololeenko.task1.service;

import java.util.OptionalInt;

public interface CalculationService {
    OptionalInt findMax(int[] array);
    OptionalInt findMin(int[] array);
    int calculateSum(int[] array);
    int calculateAverage(int[] array);
}
