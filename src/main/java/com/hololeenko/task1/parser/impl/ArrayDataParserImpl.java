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

    @Override
    public int[] parse(String line) throws WrongFormatException {

        String strippedLine = line.strip();

        int[] resultArray;

        LineValidation validation = new LineValidationImpl();

        if(validation.isValid(strippedLine)){
            LOGGER.info("Success validation for line \"{}\"", strippedLine);

            String[] parts = strippedLine.split(ARRAY_REGEX);
            resultArray = new int[parts.length];

            for(int i=0; i<parts.length; i++){
                resultArray[i] = Integer.parseInt(parts[i]);
            }

        }else{
            throw  new WrongFormatException("Line isn't valid");
        }

        LOGGER.info("Line \"{}\" was parsed to \"{}\"", line, Arrays.toString(resultArray));

        return resultArray;
    }
}
