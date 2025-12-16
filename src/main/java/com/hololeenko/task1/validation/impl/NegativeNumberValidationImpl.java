package com.hololeenko.task1.validation.impl;

import com.hololeenko.task1.validation.NegativeNumberValidation;

public class NegativeNumberValidationImpl implements NegativeNumberValidation {

    @Override
    public boolean isValid(int number) {
        return number >= 0;
    }
}
