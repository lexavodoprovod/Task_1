package com.hololeenko.task1.parser.impl;

import com.hololeenko.task1.parser.Parser;

public class StudentParserImpl implements Parser {

    private static final String REGEX = "-";

    @Override
    public String[] parse(String line) {

        String[] studentParts = line.split(REGEX);

        return studentParts;
    }
}
