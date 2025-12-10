package com.hololeenko.task1.repository;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.query.impl.FindAllArraysQueryImpl;
import com.hololeenko.task1.repository.impl.CustomArrayRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class CustomArrayRepositoryImplTest {
    private static final Logger LOGGER = LogManager.getLogger();

    private CustomArrayRepository repository;

    @BeforeEach
    void setUp() throws  WrongFormatException {
        repository = new CustomArrayRepositoryImpl();
        int[] array1 =  new int[]{1, 2, 3, 6};
        int[] array2 =  new int[]{5, 6, 8, 3};
        int[] array3 =  new int[]{1, 4, 2, 9};
        repository.saveArray(new CustomArray(array1));
        repository.saveArray(new CustomArray(array2));
        repository.saveArray(new CustomArray(array3));

    }


    @Test
    @DisplayName("Should save array")
    void saveArray()  throws WrongFormatException {
        int expectedCountOfArrays = 4;
        CustomArray array = new CustomArray(new int[]{34, 6, 9, 3});

        repository.saveArray(array);
        LOGGER.info("Save array to the repository:{}", repository.findByQuery(new FindAllArraysQueryImpl()));

        List<CustomArray> customArrays = repository.findByQuery(new FindAllArraysQueryImpl());
        assertEquals(expectedCountOfArrays, customArrays.size());
    }

    @Test
    @DisplayName("Should throw WrongFormatException if array already exist in repository")
    void saveArrayWithException(){
        int[] array1 =  new int[]{1, 2, 3, 6};
        CustomArray customArray1 = new CustomArray(array1);

        assertThrows(WrongFormatException.class,() -> repository.saveArray(customArray1));
    }

    @Test
    @DisplayName("Should remove array by ID")
    void removeArrayByID()  throws WrongFormatException {
        int expectedCountOfArrays = 2;

        repository.removeArrayByID(3);
        LOGGER.info("Remove array by id:{}", repository.findByQuery(new FindAllArraysQueryImpl()));

        List<CustomArray> customArrays = repository.findByQuery(new FindAllArraysQueryImpl());
        assertEquals(expectedCountOfArrays, customArrays.size());
    }


    @Test
    @DisplayName("Should throw WrongFormatException if array with this ID doesn't exist or 0 or <0")
    void removeArrayWithExceptionByID(){
        assertThrows(WrongFormatException.class,() -> repository.removeArrayByID(4));
        assertThrows(WrongFormatException.class,() -> repository.removeArrayByID(0));
        assertThrows(WrongFormatException.class,() -> repository.removeArrayByID(-1));
    }




    @Test
    void findArrayByIdTest() {
    }

    @Test
    void findByQueryTest() {
    }

    @Test
    void sortArrays() {
    }
}