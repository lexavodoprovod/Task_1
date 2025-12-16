package com.hololeenko.task1.service.impl;

import com.hololeenko.task1.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortServiceImpl implements SortService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int[] bubbleSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        LOGGER.info( "Array after bubble sort is \"{}\"", Arrays.toString(array));

        return array;
    }

    @Override
    public int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++){
            int minIndex = i;

            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        LOGGER.info("Array after selection sort is \"{}\"", Arrays.toString(array));

        return array;
    }
}
