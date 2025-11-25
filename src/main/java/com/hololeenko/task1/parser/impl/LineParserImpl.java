package com.hololeenko.task1.parser.impl;

import com.hololeenko.task1.parser.Parser;

public class LineParserImpl implements Parser {

    private final static String REGEX = ";";

    @Override
    public String[] parse(String line) {
        String[] parts = line.split(REGEX);
        return parts;
    }
}
