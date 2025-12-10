package com.hololeenko.task1.entity;

import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.increment.IncreaseArrayID;
import com.hololeenko.task1.observer.CustomArrayObserver;
import com.hololeenko.task1.observer.impl.CustomArrayObserverImpl;
import com.hololeenko.task1.validation.NegativeNumberValidation;
import com.hololeenko.task1.validation.impl.NegativeNumberValidationImpl;

import java.util.Arrays;


public class CustomArray {

    private final long id;
    private int[] array;
    private final CustomArrayObserver observer = new CustomArrayObserverImpl();

    public CustomArray(int[] array) {
        this.id = IncreaseArrayID.getIncreasedId();
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array.clone();
        notifyObservers();
    }

    public long getId() {
        return id;
    }

    public int getLength() {
        return array.length;
    }

    public int getElement(int index)throws WrongFormatException{
        NegativeNumberValidation validation = new NegativeNumberValidationImpl();
        if(validation.isValid(index)){
            return array[index];
        }else{
            throw new WrongFormatException("Invalid index");
        }
    }

    public void setElement(int index, int value) throws WrongFormatException {
        NegativeNumberValidation validation = new NegativeNumberValidationImpl();
        if(validation.isValid(index) || !(index > array.length)){
            array[index] = value;
            notifyObservers();
        }else{
            throw new WrongFormatException("Invalid index");
        }

    }

    public int getFirstElementOfArray() {
        return array[0];
    }

    private void notifyObservers() {
        observer.onCustomArrayChanged(this);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray array1 = (CustomArray) o;
        return id == array1.id &&  Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("ID=").append(id);
        sb.append(", array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
