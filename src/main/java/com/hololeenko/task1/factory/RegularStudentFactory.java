package com.hololeenko.task1.factory;

import com.hololeenko.task1.entity.RegularStudent;
import com.hololeenko.task1.entity.Student;

public class RegularStudentFactory extends StudentFactory {

    @Override
    public Student createStudent(long id, String lastName, int age) {
        return new RegularStudent(id, lastName, age);
    }
}
