package com.hololeenko.task1.validation;

import com.hololeenko.task1.entity.Student;
import com.hololeenko.task1.exception.WrongFormatException;

import java.util.List;

public interface Validation {
     List<String> afterValidation(String[] parts);
}
