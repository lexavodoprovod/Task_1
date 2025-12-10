package com.hololeenko.task1.observer.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.entity.CustomArrayData;
import com.hololeenko.task1.observer.CustomArrayObserver;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;
import com.hololeenko.task1.warehouse.CustomArrayWarehouse;
import com.hololeenko.task1.warehouse.impl.CustomArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.OptionalInt;

public class CustomArrayObserverImpl implements CustomArrayObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String ADD_DATA_TO_WAREHOUSE = "Adding data to warehouse for array \"{}\" with ID {}";
    private static final String CHANGE_IN_ARRAY = "Observer detected changes in array \"{}\" with ID {}";

    private final CalculationService calculationService = new CalculationServiceImpl();

    @Override
    public void onCustomArrayChanged(CustomArray customArray) {

        LOGGER.info(CHANGE_IN_ARRAY, customArray.getArray(), customArray.getId());

        OptionalInt optionalMax = calculationService.findMax(customArray.getArray());
        OptionalInt optionalMin = calculationService.findMin(customArray.getArray());

        int maxValue = optionalMax.orElse(0);
        int minValue = optionalMin.orElse(0);

        int sum = calculationService.calculateSum(customArray.getArray());
        int avg = calculationService.calculateAverage(customArray.getArray());

        CustomArrayData arrayData = new CustomArrayData(maxValue, minValue, sum, avg);

        CustomArrayWarehouse warehouse = CustomArrayWarehouseImpl.getInstance();

        LOGGER.info(ADD_DATA_TO_WAREHOUSE, customArray.getArray(), customArray.getId());
        warehouse.put(customArray.getId(), arrayData);
    }
}
