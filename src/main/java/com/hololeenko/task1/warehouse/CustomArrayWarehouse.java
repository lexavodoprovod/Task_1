package com.hololeenko.task1.warehouse;

import com.hololeenko.task1.entity.CustomArrayData;
import com.hololeenko.task1.exception.WrongFormatException;

public interface CustomArrayWarehouse {
    void put(long id, CustomArrayData arrayData);
    void remove(long id) throws WrongFormatException;
}
