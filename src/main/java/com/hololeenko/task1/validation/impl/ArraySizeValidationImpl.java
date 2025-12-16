package com.hololeenko.task1.validation.impl;

import com.hololeenko.task1.validation.ArraySizeValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class ArraySizeValidationImpl implements ArraySizeValidation {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean isValid(int[] array) {
        LOGGER.info("Size validation for array ");
        return array != null && array.length > 0;
    }
}
