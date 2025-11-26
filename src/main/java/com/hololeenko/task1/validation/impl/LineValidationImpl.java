package com.hololeenko.task1.validation.impl;

import com.hololeenko.task1.entity.Student;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidationImpl implements Validation {

    private static  final String REGEX = "^\\d+-\\w+-\\d+$";

    private final Logger logger = LogManager.getLogger(LineValidationImpl.class);


    @Override
    public List<String> afterValidation(String[] parts){
        List<String> correctStudents = new ArrayList<>();
        for(String part : parts){
            if(part.matches(REGEX)){
                correctStudents.add(part);
                logger.info("Correct part: {}", part);
            }else {
                logger.error("Wrong part: {}", part);
            }
        }


        return correctStudents;
    }
}
