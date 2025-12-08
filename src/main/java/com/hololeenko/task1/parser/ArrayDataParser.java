package com.hololeenko.task1.parser;

import com.hololeenko.task1.exception.WrongFormatException;

public interface ArrayDataParser {
    int[] parse(String line) throws WrongFormatException;
}
