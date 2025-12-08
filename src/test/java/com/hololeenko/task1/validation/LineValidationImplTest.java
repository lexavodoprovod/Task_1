package com.hololeenko.task1.validation;

import com.hololeenko.task1.validation.impl.LineValidationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineValidationImplTest {

    private LineValidationImpl lineValidationImpl;

    @BeforeEach
    void setUp() {
        lineValidationImpl = new LineValidationImpl();
    }

    @Test
    @DisplayName("Should return true for validation")
    void isValid() {
        String line = "134-1-34-12-2";

        boolean isValid = lineValidationImpl.isValid(line);

        assertTrue(isValid);
    }

}