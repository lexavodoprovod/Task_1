package com.hololeenko.task1.warehouse.impl;

import com.hololeenko.task1.entity.CustomArrayData;
import com.hololeenko.task1.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouseImpl implements CustomArrayWarehouse {

    private static final Logger LOGGER = LogManager.getLogger();

    private static CustomArrayWarehouse instance;
    private final Map<Long, CustomArrayData> storage = new HashMap<>();

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouseImpl();
        }
        return instance;
    }

    @Override
    public void put(long id, CustomArrayData arrayData) {
        storage.put(id, arrayData);
    }

    @Override
    public void remove(long id) {
        storage.remove(id);
    }
}
