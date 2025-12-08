package com.hololeenko.task1.parser;

import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.parser.impl.ArrayDataParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDataParserImplTest {

    private ArrayDataParserImpl arrayDataParser;

    @BeforeEach
    void setUp() {
        arrayDataParser = new ArrayDataParserImpl();
    }

    @Test
    @DisplayName("Should parse valid line to array")
    void testParseValidLine() throws WrongFormatException{
        String line = "134-1-34-12-2";
        int[] expected = {134, 1, 34, 12, 2};

        int[] actualArray = arrayDataParser.parse(line);

        assertArrayEquals(expected, actualArray);
    }

    @Test
    @DisplayName("Should parse line with space to array")
    void testParseLineWithSpace() throws WrongFormatException{
        String line = "   134-1-34-12-2     ";
        int[] expected = {134, 1, 34, 12, 2};

        int[] actualArray = arrayDataParser.parse(line);

        assertArrayEquals(expected, actualArray);
    }

    @Test
    @DisplayName("Should throw an exception when parsing an invalid line")
    void testParseInvalidLineThrowException() throws WrongFormatException{
        String line = "134-1-34sdf-12-2";

        assertThrows(WrongFormatException.class, () -> arrayDataParser.parse(line) );
    }


}