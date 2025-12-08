package com.hololeenko.task1.reader;

import com.hololeenko.task1.exception.WrongFormatException;

import java.util.List;

public interface DataReader {
    List<String> readFileData(String path) throws WrongFormatException;
}
