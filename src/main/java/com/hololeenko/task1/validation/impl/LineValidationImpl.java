package com.hololeenko.task1.validation.impl;

import com.hololeenko.task1.validation.LineValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineValidationImpl implements LineValidation {

    private static final Logger LOGGER = LogManager.getLogger();

    private static  final String LINE_REGEX = "^[\\d,;\\-]+$";


    @Override
    public boolean isValid(String line){
        LOGGER.info("Line validation attempt: {}", line);
        return line.matches(LINE_REGEX);
    }
}
