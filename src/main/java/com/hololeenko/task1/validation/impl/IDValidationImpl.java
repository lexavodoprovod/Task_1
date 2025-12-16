package com.hololeenko.task1.validation.impl;

import com.hololeenko.task1.validation.IDValidation;

public class IDValidationImpl implements IDValidation {
    @Override
    public boolean isValid(long id) {
        return id>0;
    }
}
