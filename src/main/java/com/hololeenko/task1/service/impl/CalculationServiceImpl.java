package com.hololeenko.task1.service.impl;

import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.validation.ArraySizeValidation;
import com.hololeenko.task1.validation.impl.ArraySizeValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalInt;

public class CalculationServiceImpl implements CalculationService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ArraySizeValidation sizeValidation = new ArraySizeValidationImpl();

    private static final String START_FIND_MAX = "Starting the search for the largest element in \"{}\"";
    private static final String SUCCESS_FIND_MAX = "The largest element is found \"{}\"";
    private static final String START_FIND_MIN = "Starting the search for the smallest element in \"{}\"";
    private static final String SUCCESS_FIND_MIN = "The smallest element is found \"{}\"";
    private static final String SUCCESS_CALCULATE_SUM = "In this array \"{}\" the sum of the values is \"{}\"";
    private static final String SUCCESS_CALCULATE_AVG = "The average value of this array \"{}\" is \"{}\"";




    @Override
    public OptionalInt findMax(int[] array) {

        if (!sizeValidation.isValid(array)) {
            LOGGER.info("Array Size Validation Failed for findMax");
            return OptionalInt.empty();
        }

        LOGGER.debug(START_FIND_MAX, array);
        OptionalInt max = Arrays.stream(array).max();
        LOGGER.debug(SUCCESS_FIND_MAX, max.getAsInt());

        return max;
    }

    @Override
    public OptionalInt findMin(int[] array) {

        if (!sizeValidation.isValid(array)) {
            LOGGER.info("Array Size Validation Failed for findMin");
            return OptionalInt.empty();
        }

        LOGGER.debug(START_FIND_MIN, array);
        OptionalInt min = Arrays.stream(array).min();
        LOGGER.info(SUCCESS_FIND_MIN, min.getAsInt());

        return min;
    }

    @Override
    public int calculateSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        LOGGER.info(SUCCESS_CALCULATE_SUM, array, sum);
        return sum;
    }

    @Override
    public int calculateAverage(int[] array) {
        int sum = 0;
        for(int value : array) {
            sum += value;
        }
        int avg = sum/array.length;
        LOGGER.info(SUCCESS_CALCULATE_AVG, array, avg);

        return avg;
    }


}
