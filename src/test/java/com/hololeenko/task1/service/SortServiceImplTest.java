package com.hololeenko.task1.service;

import com.hololeenko.task1.service.impl.SortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortServiceImplTest {

    private SortServiceImpl sortService;

    @BeforeEach
    void setUp() {
        sortService = new SortServiceImpl();
    }

    @Test
    @DisplayName("Should sort array by bubble sort")
    void bubbleSort() {
        int[] testAray = {3, 7, 1, 8};
        int[] expect = {1, 3, 7, 8};

        int[] actualArray = sortService.bubbleSort(testAray);

        assertArrayEquals(expect, actualArray);
    }

    @Test
    @DisplayName("Should sort array by selection sort")
    void selectionSort() {
        int[] testAray = {3, 7, 1, 8};
        int[] expect = {1, 3, 7, 8};

        int[] actualArray = sortService.selectionSort(testAray);

        assertArrayEquals(expect, actualArray);
    }
}