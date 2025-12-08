package com.hololeenko.task1.factory;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;

public interface CustomArrayFactory {
//    AbstractPerson createStudent(long id, String lastName, int age, String courseName);
//    AbstractPerson[] createStudentsFromFile(String path) throws WrongFormatException;
    CustomArray createCustomArray(int[] array) throws WrongFormatException;
    CustomArray createRandomArray(int size, int min, int max);

}
