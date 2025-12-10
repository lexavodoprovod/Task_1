package com.hololeenko.task1.reader.impl;

import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReaderImpl implements DataReader {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String START_READ_FILE = "Start reading file";
    private static final String FILE_NOT_EXIST = "File does not exist";
    private static final String OTHER_EXCEPTIONS = "Another exception with file";
    private static final String SUCCESS_READ_FILE = "Successfully read file";


    @Override
    public List<String> readFileData(String path) throws WrongFormatException {

        LOGGER.info(START_READ_FILE);

        Path file = Paths.get(path);
        List<String> data;

        try {
            data = Files.readAllLines(file);
            LOGGER.info(SUCCESS_READ_FILE);
        }catch (NoSuchFileException e) {
            throw new WrongFormatException(FILE_NOT_EXIST, e);
        } catch (IOException e) {
            throw new WrongFormatException(OTHER_EXCEPTIONS, e);
        }

        return data;
    }
}
