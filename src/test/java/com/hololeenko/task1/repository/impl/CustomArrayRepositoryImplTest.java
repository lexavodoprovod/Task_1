package com.hololeenko.task1.repository.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.query.impl.FindAllArraysQueryImpl;
import com.hololeenko.task1.repository.CustomArrayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;



class CustomArrayRepositoryImplTest {
    private CustomArrayRepository repository;

    @BeforeEach
    void setUp() throws  WrongFormatException {
        repository = new CustomArrayRepositoryImpl();
        int[] array1 =  new int[]{1, 2, 3, 6};
        int[] array2 =  new int[]{5, 6, 8, 3};
        int[] array3 =  new int[]{1, 4, 2, 9};
        repository.saveArray(new CustomArray(array1));
        repository.saveArray(new CustomArray(array2));
        repository.saveArray(new CustomArray(array3));

    }


    @Test
    @DisplayName("Should throw WrongFormatException if array already exist in repository")
    void saveArrayWithException(){
        int[] array1 =  new int[]{1, 2, 3, 6};
        CustomArray customArray1 = new CustomArray(array1);

        assertThrows(WrongFormatException.class,() -> repository.saveArray(customArray1));
    }

    @Test
    @DisplayName("Should throw WrongFormatException if array already exist in repository")
    void removeArrayWithException(){

        assertThrows(WrongFormatException.class,() -> repository.removeArrayByID(4));
    }


    @Test
    void findArrayByIdTest() {
    }

    @Test
    void findByQueryTest() {
    }

    @Test
    void sortArrays() {
    }
}