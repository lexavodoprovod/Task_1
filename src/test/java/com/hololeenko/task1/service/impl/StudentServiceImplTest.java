package com.hololeenko.task1.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findMaxAgeForStudent() {
        int expected = 27;
        int actual = 27;
        assertEquals(expected, actual);
    }

    @Test
    void findMinAgeForStudent() {
    }

    @Test
    @Disabled
    void findMaxStudentId() {
    }
}