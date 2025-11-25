package com.hololeenko.task1.factory;

import com.hololeenko.task1.entity.Student;

public abstract class Factory {

    protected abstract Student createStudent(long id, String lastName, int age);

    public Student registerStudent(long id, String lastName, int age) {
        Student student = createStudent(id, lastName, age);
        return student;
    }
}
