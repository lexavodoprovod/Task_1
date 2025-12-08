package com.hololeenko.task1.parser.impl;

import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.parser.ArrayDataParser;
import com.hololeenko.task1.validation.LineValidation;
import com.hololeenko.task1.validation.impl.LineValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayDataParserImpl implements ArrayDataParser {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String ARRAY_REGEX = "[;,-]";
    private static final String SUCCESS_VALIDATION = "Success validation for line \"{}\"";
    private static final String PARSING_MESSAGE = "Line \"{}\" was parsed to \"{}\"";
    private static final String EXCEPTION_MESSAGE = "Line isn't valid";


    @Override
    public int[] parse(String line) throws WrongFormatException {

        String trimmedLine = line.strip();

        LineValidation validation = new LineValidationImpl();
        int[] resultArray;

        if(validation.isValid(trimmedLine)){
            LOGGER.info(SUCCESS_VALIDATION, trimmedLine);

            String[] parts = trimmedLine.split(ARRAY_REGEX);
            resultArray = new int[parts.length];

            for(int i=0; i<parts.length; i++){
                resultArray[i] = Integer.parseInt(parts[i]);
            }

        }else{
            throw  new WrongFormatException(EXCEPTION_MESSAGE);
        }

        LOGGER.info(PARSING_MESSAGE, line, Arrays.toString(resultArray));

        return resultArray;
    }
}
