package com.hololeenko.task1.service;

import com.hololeenko.task1.service.impl.CalculationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceImplTest {

    private CalculationServiceImpl calculationService;

    @BeforeEach
    void setUp() {
        calculationService = new CalculationServiceImpl();
    }

    @Test
    @DisplayName("Should correctly find max value for array")
    void findMax() {
        int[] testAray = {3, 7, 1, 8};
        int expect = 8;

        OptionalInt actualNumber = calculationService.findMax(testAray);

        assertTrue(actualNumber.isPresent());
        assertEquals(expect, actualNumber.getAsInt());
    }

    @Test
    @DisplayName("Should correctly find min value for array")
    void findMin() {
        int[] testAray = {3, 7, 1, 8};
        int expect = 1;

        OptionalInt actualNumber = calculationService.findMin(testAray);

        assertTrue(actualNumber.isPresent());
        assertEquals(expect, actualNumber.getAsInt());
    }

    @Test
    @DisplayName("Should correctly calculate sum of values for array")
    void calculateSum() {
        int[] testAray = {3, 7, 1, 8};
        int expect = 19;

        int actualNumber = calculationService.calculateSum(testAray);

        assertEquals(expect, actualNumber);
    }

    @Test
    @DisplayName("Should correctly calculate average value for array")
    void calculateAverage() {
        int[] testAray = {3, 7, 2, 8};
        int expect = 5;

        int actualNumber = calculationService.calculateAverage(testAray);

        assertEquals(expect, actualNumber);
    }
}