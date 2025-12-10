package com.hololeenko.task1.main;

import com.hololeenko.task1.comparator.FirstElementComparator;
import com.hololeenko.task1.comparator.IDComparator;
import com.hololeenko.task1.comparator.LengthComparator;
import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.factory.CustomArrayFactory;
import com.hololeenko.task1.factory.impl.CustomArrayFactoryImpl;
import com.hololeenko.task1.parser.ArrayDataParser;
import com.hololeenko.task1.parser.impl.ArrayDataParserImpl;
import com.hololeenko.task1.query.impl.FindAllArraysQueryImpl;
import com.hololeenko.task1.query.impl.FindByElementQueryImpl;
import com.hololeenko.task1.query.impl.FindByIDQueryImpl;
import com.hololeenko.task1.reader.DataReader;
import com.hololeenko.task1.reader.impl.DataReaderImpl;
import com.hololeenko.task1.repository.CustomArrayRepository;
import com.hololeenko.task1.repository.impl.CustomArrayRepositoryImpl;
import com.hololeenko.task1.service.CalculationService;
import com.hololeenko.task1.service.SortService;
import com.hololeenko.task1.service.impl.CalculationServiceImpl;
import com.hololeenko.task1.service.impl.SortServiceImpl;
import com.hololeenko.task1.warehouse.CustomArrayWarehouse;
import com.hololeenko.task1.warehouse.impl.CustomArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Application {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        DataReader read = new DataReaderImpl();
        ArrayDataParser parser = new ArrayDataParserImpl();
        CustomArrayFactory factory = new CustomArrayFactoryImpl();

        CustomArrayRepository repository = CustomArrayRepositoryImpl.getInstance();
        CustomArrayWarehouse warehouse = CustomArrayWarehouseImpl.getInstance();

        try {
            List<String> lines = read.readFileData("data/arrays.txt");

            for(String line : lines) {
                try{
                    int[] array = parser.parse(line);

                    CustomArray customArray = factory.createCustomArray(array);

                    repository.saveArray(customArray);
                    LOGGER.info("Array {} with ID {} saved to the repository",customArray.getArray(), customArray.getId());
                }catch (WrongFormatException e){
                    LOGGER.info(e.getMessage());
                }

            }

        } catch (WrongFormatException e) {
            LOGGER.error(e.getMessage());
        }


        CalculationService calculationService = new CalculationServiceImpl();
        SortService sortService = new SortServiceImpl();

        for(CustomArray array : repository.findByQuery(new FindAllArraysQueryImpl())) {
            OptionalInt max = calculationService.findMax(array.getArray());
            OptionalInt min = calculationService.findMin(array.getArray());
            int sum = calculationService.calculateSum(array.getArray());
            int avg = calculationService.calculateAverage(array.getArray());
            int[] arrayAfterBubbleSort = sortService.bubbleSort(array.getArray());
            int[] arrayAfterSelectionSort = sortService.selectionSort(array.getArray());
            System.out.println("\n");
        }

        Optional<CustomArray> optionalArray = repository.findArrayById(1);
        try {
            CustomArray array = optionalArray.orElseThrow(WrongFormatException::new);
            LOGGER.info("Array {} with ID {} was taken from repository",array.getArray(), array.getId());

            array.setElement(2,893);
            array.setArray(new int[]{56, 5, 6, 78, 9, 2});
        } catch (WrongFormatException e){
            LOGGER.error("Not found array with ID {}", 1);
        }

        List<CustomArray> arrays = repository.findByQuery(new FindAllArraysQueryImpl());
        LOGGER.info("Found all arrays {}", arrays );

        List<CustomArray> sortedArrayByID = repository.sortArrays(new IDComparator());
        LOGGER.info("Sorted arrays by ID {}", sortedArrayByID );

        List<CustomArray> sortedArrayByFirstElement = repository.sortArrays(new FirstElementComparator());
        LOGGER.info("Sorted arrays by First Element {}", sortedArrayByFirstElement);

        List<CustomArray> sortedArrayByLength = repository.sortArrays(new LengthComparator());
        LOGGER.info("Sorted arrays by Length {}", sortedArrayByLength);

        List<CustomArray> findArrayByID = repository.findByQuery(new FindByIDQueryImpl(3));
        LOGGER.info("Found arrays by ID {}", findArrayByID);

        List<CustomArray> findArrayByElements = repository.findByQuery(new FindByElementQueryImpl());
        LOGGER.info("Found arrays by Elements {}", findArrayByElements);

        List<CustomArray> findAllArrays = repository.findByQuery(new FindAllArraysQueryImpl());
        LOGGER.info("Found all arrays {}", findAllArrays);





    }
}
