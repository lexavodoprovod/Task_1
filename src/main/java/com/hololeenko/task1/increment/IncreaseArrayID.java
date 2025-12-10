package com.hololeenko.task1.increment;

public class IncreaseArrayID {

    private static long idIdentifier;

    public static long getIncreasedId() {
        return ++idIdentifier;
    }
}
