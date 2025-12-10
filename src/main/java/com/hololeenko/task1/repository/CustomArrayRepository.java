package com.hololeenko.task1.repository;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.query.Query;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CustomArrayRepository {
    void saveArray(CustomArray array) throws WrongFormatException;
    void removeArrayByID(long id) throws WrongFormatException;
    List<CustomArray> findByQuery(Query query);
    List<CustomArray> sortArrays(Comparator<CustomArray> comparator);
}
