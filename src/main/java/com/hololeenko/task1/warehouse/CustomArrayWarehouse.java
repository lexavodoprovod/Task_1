package com.hololeenko.task1.warehouse;

import com.hololeenko.task1.entity.CustomArrayData;

public interface CustomArrayWarehouse {
    void put(long id, CustomArrayData arrayData);
    void remove(long id);
}
