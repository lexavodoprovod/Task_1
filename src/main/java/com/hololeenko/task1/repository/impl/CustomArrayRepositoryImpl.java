package com.hololeenko.task1.repository.impl;

import com.hololeenko.task1.entity.CustomArray;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.query.Query;
import com.hololeenko.task1.query.impl.FindAllArraysQueryImpl;
import com.hololeenko.task1.query.impl.FindByIDQueryImpl;
import com.hololeenko.task1.repository.CustomArrayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SAVE_ARRAY_TO_REPOSITORY=
            "Save array {} with ID {} to the repository";
    private static final String ARRAY_EXISTS=
            "Array {} with ID {} already exists";
    private static final String ARRAY_NOT_EXISTS=
            "Array with ID {} does not exist";
    private static final String REMOVE_ARRAY_FROM_REPOSITORY=
            "Remove array {} with ID {} from repository";
    private static final String GET_FROM_REPOSITORY=
            "Get array with ID {} from repository";
    private static final String GET_FROM_QUERY=
            "Get arrays from query {}";

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
            LOGGER.info(SAVE_ARRAY_TO_REPOSITORY,array.getArray(), array.getId());
            customArrays.add(array);
        }else{
            LOGGER.info(ARRAY_EXISTS,array.getArray(), array.getId());
            throw new WrongFormatException("Array already exists");
        }

    }

    @Override
    public void removeArrayByID(long id) throws WrongFormatException{
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
            LOGGER.info(REMOVE_ARRAY_FROM_REPOSITORY, arrayForRemove.getArray(), arrayForRemove.getId());
            arraysInRepository.remove(arrayForRemove);
        }else{
            LOGGER.info(ARRAY_NOT_EXISTS, id);
            throw new WrongFormatException("Array not exists");
        }


    }

    @Override
    public Optional<CustomArray> findArrayById(int id) {
        LOGGER.info(GET_FROM_REPOSITORY, id);
        return customArrays.stream()
                .filter(array -> array.getId() == id)
                .findFirst();
    }


    @Override
    public List<CustomArray> findByQuery(Query query) {
        LOGGER.info(GET_FROM_QUERY, query.getClass().getName());
       return customArrays.stream()
               .filter(query::matches)
               .toList();
    }

    @Override
    public List<CustomArray> sortArrays(Comparator<CustomArray> comparator) {

        List<CustomArray> sortedArrays = new ArrayList<>(customArrays);
        sortedArrays.sort(comparator);

        return sortedArrays;
    }
}
