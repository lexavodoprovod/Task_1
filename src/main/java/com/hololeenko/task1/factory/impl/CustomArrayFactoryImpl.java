package com.hololeenko.task1.factory.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.factory.CustomArrayFactory;
import com.hololeenko.task1.validation.ArraySizeValidation;
import com.hololeenko.task1.validation.impl.ArraySizeValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String ARRAY_CREATED = "Array \"{}\" created";
    private static final String RANDOM_ARRAY_CREATED = "Random array \"{}\" created";
    private static final String EMPTY_ARRAY = "Attempt to create empty or null array";



    @Override
    public CustomArray createCustomArray(int[] array) throws WrongFormatException {
        ArraySizeValidation sizeValidation = new ArraySizeValidationImpl();
        if(sizeValidation.isValid(array)) {
            LOGGER.info(ARRAY_CREATED, Arrays.toString(array));
            return new CustomArray(array);
        }else{
            throw new WrongFormatException(EMPTY_ARRAY);
        }

    }

    @Override
    public CustomArray createRandomArray(int size, int min, int max) {

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = min + (int) (Math.random() * (max - min + 1));
        }
        LOGGER.info(RANDOM_ARRAY_CREATED, Arrays.toString(array));

        return new CustomArray(array);
    }

}
