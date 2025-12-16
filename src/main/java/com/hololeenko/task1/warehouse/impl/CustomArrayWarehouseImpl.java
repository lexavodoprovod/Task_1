package com.hololeenko.task1.warehouse.impl;

import com.hololeenko.task1.entity.CustomArrayData;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.validation.IDValidation;
import com.hololeenko.task1.validation.impl.IDValidationImpl;
import com.hololeenko.task1.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouseImpl implements CustomArrayWarehouse {

    private static final Logger LOGGER = LogManager.getLogger();


    private static CustomArrayWarehouse instance;
    private final Map<Long, CustomArrayData> arrayDataStorage = new HashMap<>();

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouseImpl();
        }
        return instance;
    }

    private CustomArrayWarehouseImpl() {}

    @Override
    public void put(long id, CustomArrayData arrayData) {
        LOGGER.info("Put array data to Warehouse ID: {}, array data: {}", id, arrayData);
        arrayDataStorage.put(id, arrayData);
    }

    @Override
    public void remove(long id) throws WrongFormatException {
        IDValidation validation = new IDValidationImpl();
        if(validation.isValid(id)){
            arrayDataStorage.remove(id);
        }else {
            throw new WrongFormatException("Invalid ID");
        }
    }
}
