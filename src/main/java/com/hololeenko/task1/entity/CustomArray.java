package com.hololeenko.task1.entity;

import com.hololeenko.task1.increment.IncreaseArrayID;
import com.hololeenko.task1.observer.CustomArrayObserver;
import com.hololeenko.task1.observer.impl.CustomArrayObserverImpl;

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

    public int getElement(int index){
        return array[index];
    }

    public void setElement(int index, int value) {
        array[index] = value;
        notifyObservers();
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
        String sb = "CustomArray{" + "ID=" + id +
                ", array=" + Arrays.toString(array) +
                '}';
        return sb;
    }
}
