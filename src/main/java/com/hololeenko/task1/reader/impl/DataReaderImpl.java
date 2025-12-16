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

    @Override
    public List<String> readFileData(String path) throws WrongFormatException {

        LOGGER.info("Start reading file");

        Path file = Paths.get(path);
        List<String> data;

        try {
            data = Files.readAllLines(file);
            LOGGER.info("Successfully read file");
        }catch (NoSuchFileException e) {
            throw new WrongFormatException("File does not exist", e);
        } catch (IOException e) {
            throw new WrongFormatException("Another exception with file", e);
        }

        return data;
    }
}
