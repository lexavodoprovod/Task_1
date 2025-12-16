package com.hololeenko.task1.repository.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.query.impl.FindAllArraysQueryImpl;
import com.hololeenko.task1.query.impl.FindByIDQueryImpl;
import com.hololeenko.task1.repository.CustomArrayRepository;
import com.hololeenko.task1.validation.IDValidation;
import com.hololeenko.task1.validation.impl.IDValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    private static CustomArrayRepositoryImpl repository;

    private final List<CustomArray>  customArrays = new ArrayList<>();


    public static CustomArrayRepositoryImpl getInstance() {
        if (repository == null) {
            repository = new CustomArrayRepositoryImpl();
        }
        return repository;
    }


    @Override
    public void saveArray(CustomArray array) throws WrongFormatException {
        Query query = new FindAllArraysQueryImpl();
        List<CustomArray> arraysInRepository = findByQuery(query);
        boolean isExists = arraysInRepository.stream()
                .anyMatch(a -> Arrays.equals(a.getArray(), array.getArray()));

        if(!isExists){
            LOGGER.info("Save array {} with ID {} to the repository", array.getArray(), array.getId());
            customArrays.add(array);
        }else{
            LOGGER.info("Array {} with ID {} already exists", array.getArray(), array.getId());
            throw new WrongFormatException("Array already exists");
        }

    }

    @Override
    public void removeArrayByID(long id) throws WrongFormatException{
        IDValidation validation = new IDValidationImpl();
        if(validation.isValid(id)){
            Query query = new FindAllArraysQueryImpl();
            List<CustomArray> arraysInRepository = findByQuery(query);
            List<CustomArray> existCustomArrays = new ArrayList<>();

            for (CustomArray arrayInRepository : arraysInRepository) {
                if(arrayInRepository.getId() == id){
                    existCustomArrays.add(arrayInRepository);
                }
            }

            if(!existCustomArrays.isEmpty()){
                CustomArray arrayForRemove = existCustomArrays.getFirst();
                LOGGER.info("Remove array {} with ID {} from repository", arrayForRemove.getArray(), arrayForRemove.getId());
                customArrays.remove(arrayForRemove);
            }else{
                LOGGER.info("Array with ID {} does not exist", id);
                throw new WrongFormatException("Array not exists");
            }
        }else {
            LOGGER.info("ID cannot be 0 or <0");
            throw new WrongFormatException("Invalid id");
        }



    }


    @Override
    public List<CustomArray> findByQuery(Query query) {
        List<CustomArray> matchesArray = findByQuery(query);

        for(CustomArray array : customArrays){
            if(query.matches(array)){
                matchesArray.add(array);
            }
        }
        LOGGER.info("Get arrays from query {}", query.getClass().getName());

        return matchesArray;
    }

    @Override
    public List<CustomArray> sortArrays(Comparator<CustomArray> comparator) {

        List<CustomArray> sortedArrays = new ArrayList<>(customArrays);
        sortedArrays.sort(comparator);

        return sortedArrays;
    }
}
