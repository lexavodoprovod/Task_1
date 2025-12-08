package com.hololeenko.task1.validation.impl;

import com.hololeenko.task1.validation.LineValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineValidationImpl implements LineValidation {

    private static  final String LINE_REGEX = "^[\\d,;\\-]+$";
    private static final String  VALIDATION_ATTEMPT = "Line validation attempt: {}";
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public boolean isValid(String line){
        LOGGER.info(VALIDATION_ATTEMPT, line);
        return line.matches(LINE_REGEX);
    }
}
