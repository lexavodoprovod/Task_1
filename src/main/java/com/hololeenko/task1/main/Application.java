package com.hololeenko.task1.main;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.factory.CustomArrayFactory;
import com.hololeenko.task1.factory.impl.CustomArrayFactoryImpl;
import com.hololeenko.task1.parser.ArrayDataParser;
import com.hololeenko.task1.parser.impl.ArrayDataParserImpl;
import com.hololeenko.task1.reader.DataReader;
import com.hololeenko.task1.reader.impl.DataReaderImpl;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.SortService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;
import com.hololeenko.task1.service.impl.SortServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class Application {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        List<CustomArray> repository = new ArrayList<>();

        DataReader read = new DataReaderImpl();
        ArrayDataParser parser = new ArrayDataParserImpl();
        CustomArrayFactory factory = new CustomArrayFactoryImpl();

        try {
            List<String> lines = read.readFileData("data/arrays.txt");

            for(String line : lines) {
                try{
                    int[] array = parser.parse(line);
                    CustomArray customArray = factory.createCustomArray(array);
                    repository.add(customArray);
                    System.out.println(customArray);
                }catch (WrongFormatException e){
                    LOGGER.info(e.getMessage());
                }

            }

        } catch (WrongFormatException e) {
            LOGGER.error(e.getMessage());
        }


        CalculationService calculationService = new CalculationServiceImpl();
        SortService sortService = new SortServiceImpl();

        for(CustomArray array : repository) {
            OptionalInt max = calculationService.findMax(array.getArray());
            OptionalInt min = calculationService.findMin(array.getArray());
            int sum = calculationService.calculateSum(array.getArray());
            int avg = calculationService.calculateAverage(array.getArray());
            int[] arrayAfterBubbleSort = sortService.bubbleSort(array.getArray());
            int[] arrayAfterSelectionSort = sortService.selectionSort(array.getArray());
            System.out.println("\n");
        }



    }
}
